package pl.branchdev.eventscreen.presentation

import io.reactivex.rxkotlin.addTo
import pl.branchdev.eventdomain.domain.usecase.BaseEventListUsecase
import pl.branchdev.eventdomain.presentation.BaseEventListPresenter


class EventListPresenter(eventListUsecase: BaseEventListUsecase) :
    BaseEventListPresenter<ClickableEventList>(eventListUsecase) {
    override fun attachView(view: ClickableEventList) {
        super.attachView(view)
        subscribeToUiEvents()
    }

    private fun subscribeToUiEvents() {
        view?.eventViewClicked()?.subscribe { view?.openVideoView(it) }?.addTo(subscriptionCompositeDisposable)
    }
}