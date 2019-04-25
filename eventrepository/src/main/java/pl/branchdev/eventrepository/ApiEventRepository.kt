package pl.branchdev.eventrepository

import io.reactivex.Single
import pl.branchdev.data.EventDto
import pl.branchdev.network.EventsApi

class ApiEventRepository(val apiService: EventsApi) : EventRepository {
    override fun getSchedule(): Single<List<EventDto>> = apiService.getSchedule()


    override fun getEvents(): Single<List<EventDto>> = apiService.getEvents()
}