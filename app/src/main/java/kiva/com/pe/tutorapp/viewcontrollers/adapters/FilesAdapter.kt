package kiva.com.pe.tutorapp.viewcontrollers.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Files
import kiva.com.pe.tutorapp.viewcontrollers.activities.AboutFileActivity
import kotlinx.android.synthetic.main.item_file.view.*

class FilesAdapter(var files: ArrayList<Files>, val context: Context): RecyclerView.Adapter<FilesAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FilesAdapter.ViewHolder {
        return ViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.item_file, p0, false))    }

    override fun getItemCount(): Int {
        return files.size
    }

    override fun onBindViewHolder(p0: FilesAdapter.ViewHolder, p1: Int) {
        val media = files.get(p1)
        p0.updateFrom(media)

    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val iconImageView = view.iconImageView
        val titleTextView = view.titleTextView
        val mediaLayout = view.itemMedia

        fun updateFrom(files: Files) {

            titleTextView.text = files.created_at
            when (files.type) {
                1 -> iconImageView.setImageResource(R.drawable.ic_docflat)
                2 -> iconImageView.setImageResource(R.drawable.ic_imageflat)
                3->iconImageView.setImageResource(R.drawable.ic_pdfflat)
                else -> { // Note the block
                    iconImageView.setImageResource(R.drawable.ic_pdfflat)
                }
            }

            mediaLayout.setOnClickListener { view ->
                val context = view.context
                context.startActivity(Intent(context, AboutFileActivity::class.java).putExtras(files.toBundle()))
            }
        }
    }

}