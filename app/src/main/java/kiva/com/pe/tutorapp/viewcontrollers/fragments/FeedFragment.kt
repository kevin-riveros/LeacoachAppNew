package kiva.com.pe.tutorapp.viewcontrollers.fragments


import android.arch.lifecycle.LifecycleObserver
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener
import android.support.annotation.NonNull
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Media
import kiva.com.pe.tutorapp.viewcontrollers.adapters.VideosAdapter
import kotlinx.android.synthetic.main.fragment_feed.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FeedFragment : Fragment() {
    private var media=ArrayList<Media>()
    private lateinit var mediaRecyclerView: RecyclerView
    private lateinit var mediaAdapter: VideosAdapter
    private lateinit var mediaLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val video1 = Media(1,1,"Programacion 1 ","https://www.youtube.com/watch?v=0vTopF6wwZg",1)
        val video2 =Media(1,1,"Programacion 2 ","https://www.youtube.com/watch?v=0vTopF6wwZg",1)
        media.add(video1)
        media.add(video2)

        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        mediaAdapter = VideosAdapter(media, view.context)
        mediaLayoutManager = GridLayoutManager(view.context, 1) as RecyclerView.LayoutManager
        mediaRecyclerView = view.mediaRecycler
        mediaRecyclerView.adapter = mediaAdapter
        mediaRecyclerView.layoutManager = mediaLayoutManager
        return view
    }


}
