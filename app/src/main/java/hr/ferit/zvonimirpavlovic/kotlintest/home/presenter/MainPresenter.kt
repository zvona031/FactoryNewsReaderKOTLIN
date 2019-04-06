package hr.ferit.zvonimirpavlovic.kotlintest.home.presenter

import hr.ferit.zvonimirpavlovic.kotlintest.home.MainView
import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.Article
import hr.ferit.zvonimirpavlovic.kotlintest.model.interactor.ArticleInteractor

class MainPresenterImpl(private var mainView : MainView, private var articleInteractor : ArticleInteractor) : MainPresenter,ArticleInteractor.OnFinishedListener{

    private val articleArrayList = ArrayList<Article>()

    override fun onDestroy() {
       articleInteractor.onDestroy()
    }

    override fun requestDataFromServer() {
        mainView.showProgress()
        articleInteractor.getArticleArrayList(this)
    }

    override fun itemClicked(position : Int) {
            mainView.launchSingle(articleArrayList,position)
    }

    override fun onFailure(t : Throwable) {
        mainView.onResponseFailure(t)
        mainView.hideProgress()
    }

    override fun onFinished(articleList : ArrayList<Article>) {
        articleArrayList.clear()
        articleArrayList.addAll(articleList)
        mainView.setDataToRecyclerView(articleArrayList)
        mainView.hideProgress()
    }

}

interface MainPresenter{
    fun onDestroy()

    fun requestDataFromServer()

    fun itemClicked(position: Int)
}