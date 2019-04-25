package pl.branchdev.android_common.base

interface MvpPresenter<in V : MvpView> {
    fun attachView(view: V)
    fun detachView()
}

interface MvpView