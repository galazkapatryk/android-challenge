package pl.branchdev.eventscreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_event_list.*
import org.koin.android.ext.android.inject
import pl.branchdev.eventdomain.model.Event
import pl.branchdev.eventscreen.R
import pl.branchdev.eventscreen.navigation.BaseEventScreenNavigation
import pl.branchdev.eventscreen.presentation.adapter.EventListAdapter

class EventListFragment : Fragment(), ClickableEventList {
    private val navigation: BaseEventScreenNavigation by inject()
    private var eventListItemClicked: PublishSubject<String> = PublishSubject.create()
    private val presenter: EventListPresenter by inject()
    private var eventListAdapter = EventListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        presenter.attachView(this)
    }

    private fun initView() {
        fragmentEventListEvents.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventListAdapter
        }
        eventListAdapter.itemClicked.subscribe { eventListItemClicked.onNext(it) }
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
    }

    override fun eventViewClicked() = eventListItemClicked

    override fun openVideoView(videoUrl: String) {
        navigation.startPlaybackScreen(videoUrl)
    }

}