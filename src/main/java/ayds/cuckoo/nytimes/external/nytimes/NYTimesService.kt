package ayds.cuckoo.nytimes.external.nytimes

import ayds.cuckoo.nytimes.external.ExternalService
import ayds.cuckoo.nytimes.external.entities.NYTimesReviewResponse
import retrofit2.Response

class NYTimesService(
    private val nytimesAPI: NYTimesAPI,
    private val nytimesResolver: NYTimesResponseToNYTimesMovieResolver
) : ExternalService {

    override fun getMovieReview(movie: String, year: String): NYTimesReviewResponse {
        val callResponse = getNYTimesMovieFromService(movie)
        return nytimesResolver.getReviewFromExternalData(callResponse.body(), movie, year)
    }

    private fun getNYTimesMovieFromService(title: String): Response<String> {
        return nytimesAPI.getTerm(title).execute()
    }
}