package pl.branchdev.eventscreen.domain.usecase

import io.reactivex.Observable
import pl.branchdev.data.EventDto
import pl.branchdev.eventdomain.domain.usecase.BaseEventListUsecase
import pl.branchdev.eventrepository.EventRepository

class EventListUsecase(private val eventRepository: EventRepository) : BaseEventListUsecase() {
    override fun eventsDtoObservable(): Observable<List<EventDto>> = eventRepository.getEvents().toObservable()
}