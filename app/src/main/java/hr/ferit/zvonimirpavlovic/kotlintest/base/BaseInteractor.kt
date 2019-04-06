package hr.ferit.zvonimirpavlovic.kotlintest.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseInteractor : BaseInteractorInterface{

    private var compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    fun addDisposable(disposable : Disposable){
        if(compositeDisposable.isDisposed){
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable.add(disposable)
    }

}

interface BaseInteractorInterface {
    fun onDestroy()
}