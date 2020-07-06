package ayds.cuckoo2.nytimes

import ayds.cuckoo2.nytimes.entities.NYTimesReviewResponse

interface ExternalService {
    fun getMovieReview(movie: String, year: String): NYTimesReviewResponse
}