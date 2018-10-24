package kiva.com.pe.tutorapp.viewcontrollers.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Tutor
import kiva.com.pe.tutorapp.viewcontrollers.adapters.TutorAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchFragment : Fragment() {

    private lateinit var tutorRecyclerView: RecyclerView
    private lateinit var tutorAdapter: TutorAdapter
    private lateinit var tutorLayoutManager: RecyclerView.LayoutManager
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val  view = inflater.inflate(R.layout.fragment_search, container, false)

        var tabLayout = view.findViewById<TabLayout>(R.id.tabView)
        tabLayout.addTab(tabLayout.newTab().setText("TUTORES"))
        tabLayout.addTab(tabLayout.newTab().setText("ARCHIVOS"))
        tabLayout.setTabTextColors(R.color.colorIcons,R.color.colorIcons)
        /*tutorAdapter = TutorAdapter(tutor, view.context)
        tutorLayoutManager = GridLayoutManager(view.context, 1) as RecyclerView.LayoutManager
        tutorRecyclerView = view.tutorRecycler
        tutorRecyclerView.adapter = tutorAdapter
        tutorRecyclerView.layoutManager = tutorLayoutManager*/

        return view
    }


}
 