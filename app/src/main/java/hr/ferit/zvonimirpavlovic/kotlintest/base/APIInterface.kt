package hr.ferit.zvonimirpavlovic.kotlintest.base

import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.NewsCell
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("articles")
    fun getNews(@Query("apiKey") key: String, @Query("sortBy") sort: String, @Query("source") source: String): Observable<NewsCell>

}
