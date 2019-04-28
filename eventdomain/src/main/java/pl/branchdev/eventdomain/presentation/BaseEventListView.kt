package pl.branchdev.eventdomain.presentation

import pl.branchdev.android_common.base.MvpView
import pl.branchdev.eventdomain.model.Event

interface BaseEventListView : MvpView {
    fun showEventsList(events: List<Event>)
    fun showError()
}