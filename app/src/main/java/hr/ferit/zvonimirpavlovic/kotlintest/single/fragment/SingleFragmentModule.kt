package hr.ferit.zvonimirpavlovic.kotlintest.single.fragment

import org.koin.dsl.module

val singleFragmentModule = module {
    factory { (singleFragmentView : SingleFragmentView)->SingleFragmentPresenterImpl(singleFragmentView) }
}