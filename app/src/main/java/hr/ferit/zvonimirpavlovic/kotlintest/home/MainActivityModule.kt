package hr.ferit.zvonimirpavlovic.kotlintest.home


import hr.ferit.zvonimirpavlovic.kotlintest.home.presenter.MainPresenterImpl
import hr.ferit.zvonimirpavlovic.kotlintest.model.interactor.ArticleInteractor
import hr.ferit.zvonimirpavlovic.kotlintest.model.interactor.ArticleInteractorImpl
import org.koin.dsl.module

val activityModule = module{
    factory { (mainView : MainView) -> MainPresenterImpl(mainView,get()) }

    factory {  ArticleInteractorImpl(get()) as ArticleInteractor}
}