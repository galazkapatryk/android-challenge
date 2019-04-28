package pl.branchdev.eventscreen.navigation

import androidx.navigation.NavController

interface EventScreenNavigation {
    var navController: NavController?
    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }

    fun startPlaybackScreen(videoUrl: String)
}