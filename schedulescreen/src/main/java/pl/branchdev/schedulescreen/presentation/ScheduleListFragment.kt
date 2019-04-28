package pl.branchdev.schedulescreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.koin.android.ext.android.inject
import pl.branchdev.android_common.base.BaseFragment
import pl.branchdev.android_common.utils.showToastError
import pl.branchdev.eventdomain.model.Event
import pl.branchdev.eventdomain.presentation.BaseEventListView
import pl.branchdev.eventdomain.presentation.adapter.EventListAdapter
import pl.branchdev.schedulescreen.R


class ScheduleListFragment : BaseFragment(), BaseEventListView {
    private val presenter: ScheduleListPresenter by inject()
    private var eventListAdapter = EventListAdapter()
    private val linearLayoutManager by lazy { LinearLayoutManager(context) }


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
            layoutManager = linearLayoutManager
            adapter = eventListAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showEventsList(events: List<Event>) {
        eventListAdapter.adapterItems = events
        eventListAdapter.notifyItemRangeInserted(eventListAdapter.itemCount, events.size - 1)
    }

    override fun showError() {
        showToastError()
    }

}