package pl.branchdev.network

import io.reactivex.Single
import pl.branchdev.data.EventDto
import pl.branchdev.data.VideoEventDto
import pl.branchdev.network.config.ApiConfig
import retrofit2.http.GET

interface EventsApi {
    @GET(ApiConfig.SCHEDULE_URL)
    fun getSchedule(): Single<List<EventDto>>

    @GET(ApiConfig.EVENTS_URL)
    fun getEvents(): Single<List<VideoEventDto>>
}