package hr.ferit.zvonimirpavlovic.kotlintest.model.data_model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(val author: String, val title: String, val description: String, val url: String, val urlToImage: String, val publishedAt: String): Parcelable

data class NewsCell(val source: String, val sortBy: String, val articles: List<Article>)


