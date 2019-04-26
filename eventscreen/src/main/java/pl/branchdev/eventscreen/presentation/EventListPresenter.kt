package pl.branchdev.eventscreen.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import pl.branchdev.android_common.base.BasePresenter
import pl.branchdev.eventscreen.domain.usecase.BaseEventListUsecase


class EventListPresenter(private val eventListUsecase: BaseEventListUsecase) : BasePresenter<EventListView>() {
    override fun attachView(view: EventListView) {
        super.attachView(view)
        subscribeToUiEvents()
        eventListUsecase.getEvents().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                this.view?.showEventsList(it)
            }, {
                this.view?.showError()
            }).addTo(subscriptionCompositeDisposable)
    }

    private fun subscribeToUiEvents() {
        view?.eventViewClicked()?.subscribe { view?.openVideoView(it) }?.addTo(subscriptionCompositeDisposable)
    }
}