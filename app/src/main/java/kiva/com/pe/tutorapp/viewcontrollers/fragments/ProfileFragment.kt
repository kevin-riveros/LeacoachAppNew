package kiva.com.pe.tutorapp.viewcontrollers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.SettingsAccount

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        var btnLogOut = view.findViewById<Button>(R.id.logOutButton)
        btnLogOut.setOnClickListener { view ->
            val settingsLogin = SettingsAccount(view.context)
            settingsLogin.didUserLoggedIn = false
            activity?.recreate()

        }

        return view

    }


}
