package pl.branchdev.android_common.base

import androidx.navigation.NavController

interface BaseNavigation {
    var navController: NavController?
    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }
}