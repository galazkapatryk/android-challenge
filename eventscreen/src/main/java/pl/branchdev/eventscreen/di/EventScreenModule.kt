package pl.branchdev.eventscreen.di

import org.koin.dsl.module.module
import pl.branchdev.eventdomain.domain.usecase.BaseEventListUsecase
import pl.branchdev.eventscreen.domain.usecase.EventListUsecase
import pl.branchdev.eventscreen.presentation.EventListFragment
import pl.branchdev.eventscreen.presentation.EventListPresenter

val eventScreenModule = module {
    single<BaseEventListUsecase> { EventListUsecase(get()) }
    single { EventListPresenter(get()) }
    single { EventListFragment() }
}