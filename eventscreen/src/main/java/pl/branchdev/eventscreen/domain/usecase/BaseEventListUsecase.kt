package pl.branchdev.eventscreen.domain.usecase

import io.reactivex.Single
import pl.branchdev.eventscreen.model.Event

interface BaseEventListUsecase{
    fun getEvents(): Single<List<Event>>
}