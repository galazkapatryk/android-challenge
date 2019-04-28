package pl.branchdev.challenge.navigation

import pl.branchdev.android_common.base.BaseNavigation

interface BaseMainScreenNavigation : BaseNavigation {
    fun navigateToEventScreen()
    fun navigateToScheduleScreen()
}