package hr.ferit.zvonimirpavlovic.kotlintest.single

import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.Article
import kotlin.collections.ArrayList

interface SingleView {
    fun loadDataToPager(articleArrayList: ArrayList<Article>)

    fun setCurrentFragment(position: Int?)

    fun setTitle(title: String)
}