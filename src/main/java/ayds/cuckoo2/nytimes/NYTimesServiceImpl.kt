package ayds.cuckoo2.nytimes

import ayds.cuckoo2.nytimes.entities.NYTimesReview
import retrofit2.Response

internal class NYTimesServiceImpl(
    private val nytimesAPI: NYTimesAPI,
    private val nytimesResolver: NYTimesResponseToNYTimesMovieResolver
) : NYTimesService {

    override fun getMovieReview(movie: String, year: String): NYTimesReview {
        val callResponse = getNYTimesMovieFromService(movie)
        return nytimesResolver.getReviewFromExternalData(callResponse.body(), movie, year)
    }

    private fun getNYTimesMovieFromService(title: String): Response<String> {
        return nytimesAPI.getTerm(title).execute()
    }
}