package pl.branchdev.schedulescreen.di

import org.koin.dsl.module.module
import pl.branchdev.eventdomain.domain.usecase.BaseEventListUsecase
import pl.branchdev.schedulescreen.domain.ScheduleListUsecase
import pl.branchdev.schedulescreen.presentation.ScheduleListPresenter

val scheduleScreenModule = module {
    factory<BaseEventListUsecase>("scheduleUseCase") { ScheduleListUsecase(get()) }
    factory("scheduleListPresenter") { ScheduleListPresenter(get("scheduleUseCase")) }
}