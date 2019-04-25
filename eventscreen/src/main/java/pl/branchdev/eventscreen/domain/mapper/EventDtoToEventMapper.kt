package pl.branchdev.eventscreen.domain.mapper

import pl.branchdev.data.EventDto
import pl.branchdev.eventscreen.model.Event

object EventDtoToEventMapper {
    fun mapToEvent(eventDto: EventDto): Event {
        return Event(
            title = eventDto.title ?: "",
            subtitle = eventDto.subtitle ?: "",
            thumbnailUrl = eventDto.imageUrl ?: "",
            dateInformation = eventDto.date ?: ""
        )
    }
}