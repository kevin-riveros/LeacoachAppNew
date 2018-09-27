package kiva.com.pe.tutorapp.viewcontrollers.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener
import kiva.com.pe.tutorapp.R

import kotlinx.android.synthetic.main.activity_about_media.*

class AboutMediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_media)
        setSupportActionBar(toolbar)


        val youtubePlayerView = findViewById<YouTubePlayerView>(R.id.youtubePlayerView)
        lifecycle.addObserver(youtubePlayerView)

        youtubePlayerView.initialize(object : YouTubePlayerInitListener {
            override fun onInitSuccess(initializedYouTubePlayer: YouTubePlayer) {
                initializedYouTubePlayer.addListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady() {
                        val videoId = getString(R.string.test_video_id)
                        initializedYouTubePlayer.loadVideo(videoId, 0F)
                    }
                })
            }
        }, true)

    }

}
