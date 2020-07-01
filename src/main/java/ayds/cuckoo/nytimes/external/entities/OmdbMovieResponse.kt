package ayds.cuckoo.nytimes.external.entities

import java.util.*

open class OmdbMovieResponse {
    var title = ""
    var year = ""
    var plot = ""
    var director = ""
    var actors = ""
    var posterUrl = "https://i.picsum.photos/id/355/267/179.jpg"
    var isLocallyStoraged = false
    var ratings: List<RatingResponse> = ArrayList()
    var runTime = ""
}

object EmptyMovie : OmdbMovieResponse()
