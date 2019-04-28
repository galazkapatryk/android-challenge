package pl.branchdev.eventscreen.domain.usecase

import io.reactivex.Single
import pl.branchdev.data.EventDto
import pl.branchdev.eventdomain.domain.usecase.BaseEventListUsecase
import pl.branchdev.eventrepository.EventRepository

class EventListUsecase(private val eventRepository: EventRepository) : BaseEventListUsecase() {
    override fun eventsDtoObservable(): Single<List<EventDto>> = eventRepository.getEvents()
}