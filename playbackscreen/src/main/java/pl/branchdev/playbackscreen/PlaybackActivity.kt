package pl.branchdev.playbackscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.khizar1556.mkvideoplayer.MKPlayer


class PlaybackActivity : AppCompatActivity() {
    lateinit var videoPlayer: MKPlayer
    private var videoUrl: String? = null
    private var savedVideoProgress = 0

    companion object {
        const val VIDEO_URL_KEY = "VIDEO_URL"
        const val VIDEO_PROGRESS_KEY = "VIDEO_PROGRESS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playback)
        readBundle()
        readSavedState(savedInstanceState)
        playVideo()
    }

    private fun readSavedState(savedInstanceState: Bundle?) {
        savedVideoProgress = savedInstanceState?.getInt(VIDEO_PROGRESS_KEY) ?: 0
    }

    private fun playVideo() {
        videoUrl?.let {
            videoPlayer = MKPlayer(this).apply {
                play(it)
                seekTo(savedVideoProgress, false)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(VIDEO_PROGRESS_KEY, videoPlayer.currentPosition)
    }

    override fun onPause() {
        super.onPause()
        videoPlayer.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        videoPlayer.stop()
    }


    private fun readBundle() {
        videoUrl = intent?.getStringExtra(VIDEO_URL_KEY)
    }
}
