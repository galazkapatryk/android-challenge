package pl.branchdev.challenge.navigation

import androidx.navigation.NavController

class MainScreenNavigation : BaseMainScreenNavigation {
    override var navController: NavController? = null
    override fun navigateToEventScreen() {
//        navController?.navigate(
//            R.id.action_scheduleListFragment_to_eventListFragment2
//        )
    }

    override fun navigateToScheduleScreen() {
//        navController?.navigate(
//            R.id.action_eventListFragment_to_scheduleListFragment2
//        )
    }
}