package ayds.cuckoo.nytimes.external
import ayds.cuckoo.nytimes.external.entities.NYTimesReviewResponse
import ayds.cuckoo.nytimes.external.entities.OmdbMovieResponse

interface ExternalService {
    fun getMovieReview(movie: OmdbMovieResponse): NYTimesReviewResponse
}