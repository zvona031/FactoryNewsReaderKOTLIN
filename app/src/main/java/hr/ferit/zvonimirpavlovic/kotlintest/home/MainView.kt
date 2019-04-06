package hr.ferit.zvonimirpavlovic.kotlintest.home


import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.Article
import kotlin.collections.ArrayList

interface MainView {
    fun showProgress()

    fun hideProgress()

    fun setDataToRecyclerView(articleArrayList: ArrayList<Article>)

    fun onResponseFailure(throwable: Throwable)

    fun launchSingle(articleArrayList: ArrayList<Article>, position: Int)
}