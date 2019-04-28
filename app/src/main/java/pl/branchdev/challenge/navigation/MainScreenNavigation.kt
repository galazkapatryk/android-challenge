package pl.branchdev.challenge.navigation

import androidx.navigation.NavController
import pl.branchdev.challenge.R

class MainScreenNavigation : BaseMainScreenNavigation {
    override var navController: NavController? = null
    override fun navigateToEventScreen() {
        navController?.navigate(
            R.id.action_eventListFragment_to_playbackActivity
        )
    }

    override fun navigateToScheduleScreen() {
        navController?.navigate(
            R.id.action_eventListFragment_to_playbackActivity
        )
    }
}