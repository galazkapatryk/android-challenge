package pl.branchdev.eventscreen.navigation

import pl.branchdev.android_common.base.BaseNavigation

interface BaseEventScreenNavigation : BaseNavigation {
    fun startPlaybackScreen(videoUrl: String)
}