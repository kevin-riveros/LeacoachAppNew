package kiva.com.pe.tutorapp.models

import android.os.Bundle

data class settingsOptions(
        val id: String,
        val name: String,
        val icon: Int

){

    companion object {
        fun from(bundle: Bundle):settingsOptions{

            return settingsOptions(
                    bundle.getString("id"),
                    bundle.getString("name"),
                    bundle.getInt("icon")
                    )
        }
    }
    fun toBundle(): Bundle {
        val bundle = Bundle()
        with(bundle){
            putString("id",id)
            putString("name",name)
            putInt("icon",icon)
        }
        return bundle
    }
}