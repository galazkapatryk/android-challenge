package pl.branchdev.eventscreen.di

import org.koin.dsl.module.module
import pl.branchdev.eventdomain.domain.usecase.BaseEventListUsecase
import pl.branchdev.eventscreen.domain.usecase.EventListUsecase
import pl.branchdev.eventscreen.presentation.EventListPresenter

val eventScreenModule = module {
    single<BaseEventListUsecase>("eventListUseCase") { EventListUsecase(get()) }
    single("eventListPresenter") { EventListPresenter(get("eventListUseCase")) }
}