package pl.branchdev.eventscreen.presentation

import io.reactivex.subjects.PublishSubject
import pl.branchdev.android_common.base.MvpView
import pl.branchdev.eventscreen.model.Event

interface EventListView : MvpView {
    fun showEventsList(events: List<Event>)
    fun showError()
    fun eventViewClicked(): PublishSubject<String>
    fun openVideoView(videoUrl: String)
}