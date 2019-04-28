package pl.branchdev.eventscreen.presentation

import io.reactivex.subjects.PublishSubject
import pl.branchdev.eventdomain.presentation.BaseEventListView

interface ClickableEventList : BaseEventListView {
    fun eventViewClicked(): PublishSubject<String>
    fun openVideoView(videoUrl: String)
}