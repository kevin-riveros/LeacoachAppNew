package kiva.com.pe.tutorapp.models

import android.os.Bundle


data class Tutor(
        val id: Int,

        val name: String?

){
    companion object {
        fun from(bundle: Bundle):Tutor{

            return Tutor(
                    bundle.getInt("id"),
                    bundle.getString("name")
            )
        }
    }
    fun toBundle(): Bundle {
        val bundle = Bundle()
        with(bundle){
            putInt("id",id)
            putString("name",name)

        }
        return bundle
    }



}