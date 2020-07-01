package ayds.cuckoo.nytimes.external.nytimes
import ayds.cuckoo.nytimes.external.ExternalService
import ayds.cuckoo.nytimes.external.entities.NYTimesReviewResponse
import ayds.cuckoo.nytimes.external.entities.OmdbMovieResponse
import retrofit2.Response

internal class NYTimesService(
    private val nytimesAPI: NYTimesAPI,
    private val nytimesResolver: NYTimesResponseToNYTimesMovieResolver
) : ExternalService {

    override fun getMovieReview(movie: OmdbMovieResponse): NYTimesReviewResponse {
        val callResponse = getNYTimesMovieFromService(movie.title)
        return nytimesResolver.getReviewFromExternalData(callResponse.body(), movie)
    }

    private fun getNYTimesMovieFromService(title: String): Response<String> {
        return nytimesAPI.getTerm(title).execute()
    }
}