package pl.branchdev.challenge.navigation

import android.os.Bundle
import androidx.navigation.NavController
import pl.branchdev.challenge.R
import pl.branchdev.eventscreen.navigation.BaseEventScreenNavigation
import pl.branchdev.playbackscreen.PlaybackActivity.Companion.VIDEO_URL_KEY

class EventScreenNavigation : BaseEventScreenNavigation {
    override var navController: NavController? = null

    override fun startPlaybackScreen(videoUrl: String) {
        val bundle = Bundle().apply { putString(VIDEO_URL_KEY, videoUrl) }
        navController?.navigate(
            R.id.action_eventListFragment_to_playbackActivity, bundle
        )
    }
}