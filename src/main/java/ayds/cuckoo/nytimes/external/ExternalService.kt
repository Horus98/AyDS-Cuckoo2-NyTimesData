package ayds.cuckoo.nytimes.external

import ayds.cuckoo.nytimes.external.entities.NYTimesReviewResponse

interface ExternalService {
    fun getMovieReview(movie: String, year: String): NYTimesReviewResponse
}