package hr.ferit.zvonimirpavlovic.kotlintest.model.interactor

import hr.ferit.zvonimirpavlovic.kotlintest.base.APIInterface
import hr.ferit.zvonimirpavlovic.kotlintest.base.BaseInteractor
import hr.ferit.zvonimirpavlovic.kotlintest.base.BaseInteractorInterface
import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.Article
import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.NewsCell
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlin.collections.ArrayList


class ArticleInteractorImpl(private val apiInterface : APIInterface) : BaseInteractor(), ArticleInteractor {

    override fun getArticleArrayList(onFinishedListener : ArticleInteractor.OnFinishedListener) {
        val disposable = apiInterface.getNews("6946d0c07a1c4555a4186bfcade76398", "top", "bbc-news")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map{t: NewsCell -> ArrayList<Article>(t.articles)
            }
            .subscribe({data -> onFinishedListener.onFinished(data)},{t-> onFinishedListener.onFailure(t)})
        addDisposable(disposable)
    }
}

interface ArticleInteractor : BaseInteractorInterface{
    interface OnFinishedListener {

        fun onFinished(articleList: ArrayList<Article>)

        fun onFailure(t: Throwable)
    }

    fun getArticleArrayList(onFinishedListener: OnFinishedListener)
}
