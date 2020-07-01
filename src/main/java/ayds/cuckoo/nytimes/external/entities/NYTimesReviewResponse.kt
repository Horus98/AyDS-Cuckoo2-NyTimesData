package ayds.cuckoo.nytimes.external.entities

open class NYTimesReviewResponse(var title: String?, var summary: String?, var imageUrl: String?, var linkReview: String?)

object EmptyReviewResponse : NYTimesReviewResponse("", "", "https://www.shareicon.net/data/256x256/2016/06/25/618683_new_256x256.png","")
