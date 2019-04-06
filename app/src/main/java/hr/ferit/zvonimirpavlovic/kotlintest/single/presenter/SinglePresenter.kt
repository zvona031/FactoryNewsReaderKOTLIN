package hr.ferit.zvonimirpavlovic.kotlintest.single.presenter

import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.Article
import hr.ferit.zvonimirpavlovic.kotlintest.single.SingleView
import kotlin.collections.ArrayList

class SinglePresenterImpl(private val singleView : SingleView ) : SinglePresenter {

    private var articleArrayList = ArrayList<Article>()
    private var position : Int? = null


    override fun getFragmentPosition() {
       singleView.setCurrentFragment(position)
    }

    override fun getData() {
        singleView.loadDataToPager(articleArrayList)
    }

    override fun getTitle(position: Int) {
       val title = articleArrayList[position].title
        singleView.setTitle(title)
    }

    override fun saveDataFromIntent(articleArrayList: ArrayList<Article>, position: Int) {
       this.articleArrayList.clear()
       this.articleArrayList.addAll(articleArrayList)
       this.position= position
    }

}

interface SinglePresenter {
    fun saveDataFromIntent(articleArrayList: ArrayList<Article>, position: Int)

    fun getFragmentPosition()

    fun getData()

    fun getTitle(position: Int)
}