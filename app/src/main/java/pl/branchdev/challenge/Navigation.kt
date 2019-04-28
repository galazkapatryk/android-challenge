package pl.branchdev.challenge

import android.os.Bundle
import androidx.navigation.NavController
import pl.branchdev.eventscreen.navigation.EventScreenNavigation
import pl.branchdev.playbackscreen.PlaybackActivity.Companion.VIDEO_URL_KEY

class Navigation : EventScreenNavigation {
    override var navController: NavController? = null

    override fun startPlaybackScreen(videoUrl: String) {
        val bundle = Bundle().apply { putString(VIDEO_URL_KEY, videoUrl) }
        navController?.navigate(
            R.id.action_eventListFragment_to_playbackActivity, bundle
        )
    }
}