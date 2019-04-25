package pl.branchdev.eventscreen.domain.usecase

import io.reactivex.Single
import pl.branchdev.data.EventDto
import pl.branchdev.eventrepository.EventRepository
import pl.branchdev.eventscreen.domain.mapper.EventDtoToEventMapper
import pl.branchdev.eventscreen.model.Event
import java.text.SimpleDateFormat
import java.util.*

class EventListUsecase(val eventRepository: EventRepository) : BaseEventListUsecase {
    private val dateComperator =
        compareBy<EventDto> {
            SimpleDateFormat(EventDtoToEventMapper.API_DATE_FORMAT, Locale.GERMAN).parse(it.date).time
        }

    override fun getEvents(): Single<List<Event>> {
        return eventRepository.getEvents()
            .map { orderByDateAscending(it) }
            .map { eventsDtoList -> eventsDtoList.map { EventDtoToEventMapper.mapToEvent(it) } }
    }

    private fun orderByDateAscending(unorderedList: List<EventDto>): List<EventDto> =
        unorderedList.sortedWith(dateComperator)

}