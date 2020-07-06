package ayds.cuckoo2.nytimes

import ayds.cuckoo2.nytimes.entities.NYTimesReview

interface NYTimesService {
    fun getMovieReview(movie: String, year: String): NYTimesReview
}