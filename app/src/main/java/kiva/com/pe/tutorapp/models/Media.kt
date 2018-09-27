package kiva.com.pe.tutorapp.models

import android.os.Bundle

data class Media(
        val id: Int,
        val tutor_speciality_id: Int,
        val created_at: String?,
        val url: String?,
        val views: Int
){
    companion object {
        fun from(bundle: Bundle):Media{

            return Media(
                    bundle.getInt("id"),
                    bundle.getInt("tutor_speciality_id"),
                    bundle.getString("created_at"),
                    bundle.getString("url"),
                    bundle.getInt("views")
            )
        }
    }
    fun toBundle(): Bundle {
        val bundle = Bundle()
        with(bundle){
            putInt("id",id)
            putInt("tutor_speciality_id",tutor_speciality_id)
            putString("created_at",created_at)
            putString("url",url)
            putInt("views",views)

        }
        return bundle
    }



}