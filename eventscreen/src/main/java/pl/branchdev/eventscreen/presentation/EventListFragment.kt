package pl.branchdev.eventscreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_events.*
import org.koin.android.ext.android.inject
import pl.branchdev.android_common.base.BaseFragment
import pl.branchdev.android_common.utils.showToastError
import pl.branchdev.eventdomain.model.Event
import pl.branchdev.eventdomain.presentation.adapter.EventListAdapter
import pl.branchdev.eventscreen.R
import pl.branchdev.eventscreen.navigation.BaseEventScreenNavigation

class EventListFragment : BaseFragment(), ClickableEventList {
    private val navigation: BaseEventScreenNavigation by inject()
    private var eventListItemClicked: PublishSubject<String> = PublishSubject.create()
    private val presenter: EventListPresenter by inject()
    private var eventListAdapter = EventListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        presenter.attachView(this)
    }

    private fun initView() {
        fragmentEventsListLayout.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventListAdapter
        }
        eventListAdapter.itemClicked.subscribe { eventListItemClicked.onNext(it) }.addTo(uiSubscriptionComposite)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showEventsList(events: List<Event>) {
        eventListAdapter.adapterItems = events
        eventListAdapter.notifyDataSetChanged()
    }

    override fun showError() {
        showToastError()
    }

    override fun eventViewClicked() = eventListItemClicked

    override fun openVideoView(videoUrl: String) {
        navigation.startPlaybackScreen(videoUrl)
    }

}