package hr.ferit.zvonimirpavlovic.kotlintest.single

import android.support.v4.app.FragmentManager
import hr.ferit.zvonimirpavlovic.kotlintest.single.adapter.ScreenSlidePagerAdapter
import hr.ferit.zvonimirpavlovic.kotlintest.single.presenter.SinglePresenterImpl
import org.koin.dsl.module

val singleActivityModule = module {
    factory { (singleView : SingleView) ->SinglePresenterImpl(singleView) }

    factory { (fm : FragmentManager) -> ScreenSlidePagerAdapter(fm) }
}