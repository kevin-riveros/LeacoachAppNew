package kiva.com.pe.tutorapp.viewcontrollers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Tutor
import kotlinx.android.synthetic.main.item_file.view.*
import kotlinx.android.synthetic.main.item_tutor.view.*

class TutorAdapter(var tutor: ArrayList<Tutor>, val context: Context): RecyclerView.Adapter<TutorAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TutorAdapter.ViewHolder {
        return ViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.item_tutor, p0, false))    }

    override fun getItemCount(): Int {
        return tutor.size
    }

    override fun onBindViewHolder(p0: TutorAdapter.ViewHolder, p1: Int) {
        val tutor = tutor.get(p1)
        p0.updateFrom(tutor)

    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val pictureImageView = view.tutorImageView
        val titleTextView = view.titleTextView
        val mediaLayout = view.itemTutor

        fun updateFrom(tutor: Tutor) {

            titleTextView.text = tutor.name
            pictureImageView.setImageResource(R.mipmap.teacher)
            /*with(pictureImageView) {
                setDefaultImageResId(R.mipmap.ic_launcher)
                setErrorImageResId(R.mipmap.ic_launcher)
                setImageUrl(files.url)
            }*/
            mediaLayout.setOnClickListener { view ->
                val context = view.context
                //context.startActivity(Intent(context, AboutTutActivity::class.java).putExtras(tutor.toBundle()))
                Toast.makeText(context,"Open About Tutor",Toast.LENGTH_LONG).show()
            }
        }
    }

}