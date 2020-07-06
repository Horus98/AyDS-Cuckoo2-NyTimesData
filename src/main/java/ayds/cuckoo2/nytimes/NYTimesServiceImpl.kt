package ayds.cuckoo2.nytimes

import ayds.cuckoo2.nytimes.entities.NYTimesReviewResponse
import retrofit2.Response

class NYTimesServiceImpl(
    private val nytimesAPI: NYTimesAPI,
    private val nytimesResolver: NYTimesResponseToNYTimesMovieResolver
) : NYTimesService {

    override fun getMovieReview(movie: String, year: String): NYTimesReviewResponse {
        val callResponse = getNYTimesMovieFromService(movie)
        return nytimesResolver.getReviewFromExternalData(callResponse.body(), movie, year)
    }

    private fun getNYTimesMovieFromService(title: String): Response<String> {
        return nytimesAPI.getTerm(title).execute()
    }
}