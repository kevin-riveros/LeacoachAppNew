package kiva.com.pe.tutorapp.viewcontrollers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Files
import kiva.com.pe.tutorapp.models.SettingsAccount
import kiva.com.pe.tutorapp.models.settingsOptions
import kiva.com.pe.tutorapp.viewcontrollers.adapters.FilesAdapter
import kiva.com.pe.tutorapp.viewcontrollers.adapters.settingsAdapter
import kotlinx.android.synthetic.main.fragment_favorite.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : Fragment() {

    private var settingsOption=ArrayList<settingsOptions>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: settingsAdapter
    private lateinit var settingsLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val setOp1 = settingsOptions("1","cambiar contraseña",R.drawable.ic_lock_black_24dp)
        val setOp2 =settingsOptions("2","cambiar email",R.drawable.ic_email_black_24dp)
        val setOp3 =settingsOptions("3","Notificaciones",R.drawable.ic_notifications_black_24dp)
        val setOp4 =settingsOptions("4","Ayuda",R.drawable.ic_help_black_24dp)
        val setOp5 = settingsOptions("5","Logout",R.drawable.ic_logout_black)

        settingsOption.add(setOp1)
        settingsOption.add(setOp2)
        settingsOption.add(setOp3)
        settingsOption.add(setOp4)
        settingsOption.add(setOp5)

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        adapter = settingsAdapter(settingsOption, view.context)
        settingsLayoutManager = GridLayoutManager(view.context, 1) as RecyclerView.LayoutManager
        recyclerView = view.profilerecycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = settingsLayoutManager

        return view

    }


}
