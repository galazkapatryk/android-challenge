package pl.branchdev.eventscreen

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import pl.branchdev.eventscreen.domain.usecase.BaseEventListUsecase
import pl.branchdev.eventscreen.model.Event
import pl.branchdev.eventscreen.presentation.EventListPresenter
import pl.branchdev.eventscreen.presentation.EventListView

class EventListPresenterTest {
    private var baseEventListUsecase = Mockito.mock(BaseEventListUsecase::class.java)
    private var view = Mockito.mock(EventListView::class.java)
    private val eventItemClick: PublishSubject<String> = PublishSubject.create()
    private lateinit var presenter: EventListPresenter

    @Before
    fun setupTests() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        presenter = EventListPresenter(baseEventListUsecase)
    }

    @Test
    fun `when presenter get list after view attach then should show list at view`() {
        val list = emptyList<Event>()
        whenever(baseEventListUsecase.getEvents()).thenReturn(Single.just(list))
        presenter.attachView(view)
        verify(view).showEventsList(list)
    }

    @Test
    fun `when presenter get error after view attach then should show error at view`() {
        whenever(baseEventListUsecase.getEvents()).thenReturn(Single.error(Throwable()))
        presenter.attachView(view)
        verify(view).showError()
    }

    @Test
    fun `when user click event item then view should open video screen`() {
        val list = emptyList<Event>()
        whenever(baseEventListUsecase.getEvents()).thenReturn(Single.just(list))
        whenever(view.eventViewClicked()).thenReturn(eventItemClick)
        presenter.attachView(view)
        presenter.subscriptionCompositeDisposable = CompositeDisposable()
        val videoUrl = "xyz"
        eventItemClick.onNext("xyz")
        verify(view).openVideoView(videoUrl)
    }
}