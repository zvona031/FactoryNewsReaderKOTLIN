package hr.ferit.zvonimirpavlovic.kotlintest.home.adapter

import org.koin.dsl.module

val adapterModule = module {
    factory { (recyclerItemClickListener : RecyclerItemClickListener) -> RecyclerAdapter(recyclerItemClickListener) }
}