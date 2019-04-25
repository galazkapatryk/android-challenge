package pl.branchdev.eventrepository

import io.reactivex.Single
import pl.branchdev.data.EventDto

class MockEventRepository : EventRepository {
    override fun getSchedule(): Single<List<EventDto>> {
        return Single.just(emptyList())
    }

    override fun getEvents(): Single<List<EventDto>> {
        return Single.just(emptyList())
    }
}