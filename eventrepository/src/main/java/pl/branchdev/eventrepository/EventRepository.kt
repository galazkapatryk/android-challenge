package pl.branchdev.eventrepository

import io.reactivex.Single
import pl.branchdev.data.EventDto

interface EventRepository {
    fun getSchedule(): Single<List<EventDto>>
    fun getEvents(): Single<List<EventDto>>
}