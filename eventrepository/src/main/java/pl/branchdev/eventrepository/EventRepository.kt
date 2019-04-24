package pl.branchdev.eventrepository

import io.reactivex.Single
import pl.branchdev.data.EventDto
import pl.branchdev.data.VideoEventDto

interface EventRepository {
    fun getSchedule(): Single<List<EventDto>>
    fun getEvents(): Single<List<VideoEventDto>>
}