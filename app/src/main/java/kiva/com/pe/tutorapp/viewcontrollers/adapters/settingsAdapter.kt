package kiva.com.pe.tutorapp.viewcontrollers.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Files
import kiva.com.pe.tutorapp.models.settingsOptions
import kiva.com.pe.tutorapp.viewcontrollers.activities.AboutFileActivity
import kotlinx.android.synthetic.main.item_file.view.*
import kotlinx.android.synthetic.main.item_settings.view.*

class settingsAdapter (var settingsoptions: ArrayList<settingsOptions>, val context: Context): RecyclerView.Adapter<settingsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): settingsAdapter.ViewHolder {
        return ViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.item_settings, p0, false))    }

    override fun getItemCount(): Int {
        return settingsoptions.size
    }

    override fun onBindViewHolder(p0: settingsAdapter.ViewHolder, p1: Int) {
        val soptions = settingsoptions.get(p1)
        p0.updateFrom(soptions)

    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imageIconset = view.iconSettingsImageView
        val labelNameset = view.nameTextView
        val itemSettingOption = view.item_settings

        fun updateFrom(settingOptions: settingsOptions) {

            labelNameset?.text = settingOptions.name
            imageIconset.setImageResource(settingOptions.icon)
            itemSettingOption!!.setOnClickListener {

                view ->
                val context = view.context
                Toast.makeText(context,"Open this option setting",Toast.LENGTH_LONG).show()
            }

        }
    }

}