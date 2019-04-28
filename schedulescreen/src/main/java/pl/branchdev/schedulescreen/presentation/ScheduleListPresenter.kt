package pl.branchdev.schedulescreen.presentation

import pl.branchdev.eventdomain.domain.usecase.BaseEventListUsecase
import pl.branchdev.eventdomain.presentation.BaseEventListPresenter
import pl.branchdev.eventdomain.presentation.BaseEventListView

class ScheduleListPresenter(scheduleListUsecase: BaseEventListUsecase) :
    BaseEventListPresenter<BaseEventListView>(scheduleListUsecase)

