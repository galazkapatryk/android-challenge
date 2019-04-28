package pl.branchdev.eventdomain.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import pl.branchdev.android_common.base.BasePresenter
import pl.branchdev.eventdomain.domain.usecase.BaseEventListUsecase
 abstract class BaseEventListPresenter<T: BaseEventListView>(private val eventListUsecase: BaseEventListUsecase) :
    BasePresenter<T>() {
    override fun attachView(view: T) {
        super.attachView(view)
        getEventList()
    }

    private fun getEventList() {
        eventListUsecase.getEvents().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                this.view?.showEventsList(it)
            }, {
                this.view?.showError()
            }).addTo(subscriptionCompositeDisposable)
    }

}