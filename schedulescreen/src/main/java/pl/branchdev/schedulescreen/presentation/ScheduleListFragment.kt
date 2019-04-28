package pl.branchdev.schedulescreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.koin.android.ext.android.inject
import pl.branchdev.eventdomain.model.Event
import pl.branchdev.eventdomain.presentation.BaseEventListView
import pl.branchdev.eventdomain.presentation.adapter.EventListAdapter
import pl.branchdev.schedulescreen.R

class ScheduleListFragment : Fragment(), BaseEventListView {
    private val presenter: ScheduleListPresenter by inject()
    private var eventListAdapter = EventListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        presenter.attachView(this)
    }

    private fun initView() {
        fragmentScheduleListLayout.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventListAdapter
        }
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
}