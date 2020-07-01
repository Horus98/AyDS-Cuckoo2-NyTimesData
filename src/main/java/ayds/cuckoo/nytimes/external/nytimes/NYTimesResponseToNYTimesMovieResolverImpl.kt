package ayds.cuckoo.nytimes.external.nytimes

import ayds.cuckoo.nytimes.external.entities.EmptyReviewResponse
import ayds.cuckoo.nytimes.external.entities.NYTimesReviewResponse
import ayds.cuckoo.nytimes.external.entities.OmdbMovieResponse
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

internal interface NYTimesResponseToNYTimesMovieResolver {
    fun getReviewFromExternalData(body: String?, movie: OmdbMovieResponse): NYTimesReviewResponse
}

internal class NYTimesResponseToNYTimesMovieResolverImpl :
    NYTimesResponseToNYTimesMovieResolver {
    override fun getReviewFromExternalData(body: String?, movie: OmdbMovieResponse): NYTimesReviewResponse {
        val result = getJsonObject(body, movie)
        val summary = getSummaryInfo(result)
        return if (summary == "")
            EmptyReviewResponse
        else NYTimesReviewResponse(
            movie.title,
            getSummaryInfo(result),
            getPathImage(result),
            getLinkURL(result)
        )
    }

    private fun getJsonObject(body: String?, movie: OmdbMovieResponse): JsonObject? {
        val gson = Gson()
        val jObj = gson.fromJson(body, JsonObject::class.java)
        val resultIterator: Iterator<JsonElement> = jObj["results"].asJsonArray.iterator()
        var result: JsonObject? = null
        var sameYear = false
        while (resultIterator.hasNext() && !sameYear) {
            result = resultIterator.next().asJsonObject
            val year = result["publication_date"].asString.split("-").toTypedArray()[0]
            sameYear = year == movie.year
        }
        return result
    }

    private fun getSummaryInfo(movie: JsonObject?): String {
        if (movie == null) return "No results"
        return movie["summary_short"].toString()
    }

    private fun getLinkURL(movie: JsonObject?): String {
        if (movie == null) return "No results"
        return movie["link"].asJsonObject["url"].toString()
    }

    private fun getPathImage(multi: JsonObject?): String {
        if (multi != null) {
            val multimediaJson = multi["multimedia"]
            val multimedia = getMultimediaJson(multimediaJson)
            if (multimedia != null) return multimedia["src"].asString
        }
        return pathNoFound
    }

    private fun getMultimediaJson(multimediaJson: JsonElement): JsonObject? {
        var multimedia: JsonObject? = null
        if (multimediaJson.isJsonObject) multimedia = multimediaJson.asJsonObject
        return multimedia
    }

    companion object {
        private const val pathNoFound = "https://www.shareicon.net/data/256x256/2016/06/25/618683_new_256x256.png"
    }
}