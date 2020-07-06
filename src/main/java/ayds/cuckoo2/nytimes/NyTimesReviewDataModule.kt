package ayds.cuckoo2.nytimes

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object NyTimesReviewDataModule{

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/movies/v2/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

    private fun getNyTimesAPI(): NYTimesAPI = retrofit.create(
        NYTimesAPI::class.java)

    val nyTimesService = NYTimesService(
        getNyTimesAPI(),
        NYTimesResponseToNYTimesMovieResolverImpl()
    )
}