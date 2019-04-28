package pl.branchdev.eventdomain.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import pl.branchdev.eventdomain.R
import pl.branchdev.eventdomain.model.Event
import pl.branchdev.eventdomain.presentation.viewholder.EventViewHolder

class EventListAdapter : RecyclerView.Adapter<EventViewHolder>() {
    var adapterItems = listOf<Event>()
    val itemClicked: PublishSubject<String> = PublishSubject.create()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun getItemCount() = adapterItems.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.onBind(adapterItems[position])
        holder.itemView.setOnClickListener { itemClicked.onNext(adapterItems[position].videoUrl) }
    }

}