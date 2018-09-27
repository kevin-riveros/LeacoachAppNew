package kiva.com.pe.tutorapp.viewcontrollers.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Media
import kiva.com.pe.tutorapp.viewcontrollers.activities.AboutMediaActivity
import kotlinx.android.synthetic.main.item_media.view.*

class VideosAdapter(var media: ArrayList<Media>, val context: Context): RecyclerView.Adapter<VideosAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VideosAdapter.ViewHolder {
        return ViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.item_media, p0, false))    }

    override fun getItemCount(): Int {
        return media.size
    }

    override fun onBindViewHolder(p0: VideosAdapter.ViewHolder, p1: Int) {
        val media = media.get(p1)
        p0.updateFrom(media)

    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val pictureImageView = view.thumbnailImageView
        val titleTextView = view.titleTextView
        val mediaLayout = view.itemMedia

        fun updateFrom(media: Media) {

            titleTextView.text = media.created_at
            pictureImageView.setImageResource(R.mipmap.video_default)
            /*with(pictureImageView) {
                setDefaultImageResId(R.mipmap.ic_launcher)
                setErrorImageResId(R.mipmap.ic_launcher)
                setImageUrl(media.url)
            }*/
            mediaLayout.setOnClickListener { view ->
                val context = view.context
                context.startActivity(Intent(context,AboutMediaActivity::class.java).putExtras(media.toBundle()))
            }
        }
    }

}