package pl.branchdev.eventdomain.domain.usecase

import io.reactivex.Single
import pl.branchdev.data.EventDto
import pl.branchdev.eventdomain.domain.mapper.EventDtoToEventMapper
import pl.branchdev.eventdomain.model.Event
import java.text.SimpleDateFormat
import java.util.*

abstract class BaseEventListUsecase {

    private val dateComperator =
        compareBy<EventDto> {
            SimpleDateFormat(EventDtoToEventMapper.API_DATE_FORMAT, Locale.GERMAN).parse(it.date).time
        }

    fun getEvents(): Single<List<Event>> {
        return eventsDtoObservable()
            .map { orderByDateAscending(it) }
            .map { eventsDtoList -> eventsDtoList.map { EventDtoToEventMapper.mapToEvent(it) } }
    }

    private fun orderByDateAscending(unorderedList: List<EventDto>): List<EventDto> =
        unorderedList.sortedWith(dateComperator)

    abstract fun eventsDtoObservable(): Single<List<EventDto>>
}