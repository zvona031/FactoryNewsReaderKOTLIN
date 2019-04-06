package hr.ferit.zvonimirpavlovic.kotlintest.base

import android.app.Application
import hr.ferit.zvonimirpavlovic.kotlintest.home.activityModule
import hr.ferit.zvonimirpavlovic.kotlintest.home.adapter.adapterModule
import hr.ferit.zvonimirpavlovic.kotlintest.single.fragment.singleFragmentModule
import hr.ferit.zvonimirpavlovic.kotlintest.single.singleActivityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(retrofitModule, activityModule, adapterModule, singleActivityModule, singleFragmentModule))
        }
    }

    companion object {
        const val ARTICLELIST : String = "articleArrayList"
        const val POSITION : String = "position"
        const val TITLE : String = "title"
        const val DESCRIPTION : String = "description"
        const val URL : String = "url"
        const val BASE_API: String = "https://newsapi.org/v1/"
    }
}