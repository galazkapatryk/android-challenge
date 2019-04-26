package pl.branchdev.eventscreen.presentation.viewholder

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_event.view.*
import pl.branchdev.android_common.base.BaseViewHolder
import pl.branchdev.eventscreen.model.Event

class EventViewHolder(itemView: View) : BaseViewHolder<Event>(itemView) {

    override fun onBind(model: Event) {
        with(itemView) {
            Glide.with(itemEventThumbnail).load(model.thumbnailUrl).into(itemEventThumbnail)
            itemEventTitle.text = model.title
            itemEventSubtitle.text = model.subtitle
            itemEventDateInformation.text = model.dateInformation
        }
    }

}