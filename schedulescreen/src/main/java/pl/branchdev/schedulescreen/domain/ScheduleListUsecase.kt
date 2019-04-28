package pl.branchdev.schedulescreen.domain

import io.reactivex.Observable
import pl.branchdev.data.EventDto
import pl.branchdev.eventdomain.domain.usecase.BaseEventListUsecase
import pl.branchdev.eventrepository.EventRepository
import java.util.concurrent.TimeUnit

class ScheduleListUsecase(private val eventRepository: EventRepository) : BaseEventListUsecase() {
    companion object {
        const val SCHEDULE_REQUEST_INTERVAL = 2L
    }

    override fun eventsDtoObservable(): Observable<List<EventDto>> {
        return Observable.interval(SCHEDULE_REQUEST_INTERVAL, TimeUnit.SECONDS).startWith(1).flatMap {
            return@flatMap eventRepository.getSchedule().toObservable()
        }
    }
}