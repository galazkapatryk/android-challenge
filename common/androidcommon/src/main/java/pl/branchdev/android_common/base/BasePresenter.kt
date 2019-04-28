package pl.branchdev.android_common.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {
    var view: V? = null
    var subscriptionCompositeDisposable: CompositeDisposable = CompositeDisposable()

    private fun clearCompositeDisposable() {
        subscriptionCompositeDisposable.clear()
    }

    override fun detachView() {
        view = null
        clearCompositeDisposable()
    }

    override fun attachView(view: V) {
        this.view = view
    }
}