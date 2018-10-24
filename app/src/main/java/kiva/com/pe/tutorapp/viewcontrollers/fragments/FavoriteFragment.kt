package kiva.com.pe.tutorapp.viewcontrollers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Files
import kiva.com.pe.tutorapp.viewcontrollers.adapters.FilesAdapter
import kotlinx.android.synthetic.main.fragment_favorite.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FavoriteFragment : Fragment() {
    private var files=ArrayList<Files>()
    private lateinit var fileRecyclerView: RecyclerView
    private lateinit var fileAdapter: FilesAdapter
    private lateinit var fileLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val file1 = Files(1,1,"Programacion 1 ","a",1,1)
        val file2 =Files(1,1,"Programacion 2 ","a",1,1)
        val file3 =Files(1,1,"Calculo 1- derivadas ","a",1,2)
        val file4 =Files(1,1,"Matematica financiera ","a",1,3)
        val file5 = Files(1,1,"Programacion 1 ","a",1,3)
        val file6 =Files(1,1,"Programacion 2 ","a",1,3)
        val file7 =Files(1,1,"Calculo 1- derivadas ","a",1,2)
        val file8 =Files(1,1,"Matematica financiera ","a",1,1)
        files.add(file1)
        files.add(file2)
        files.add(file3)
        files.add(file4)
        files.add(file5)
        files.add(file6)
        files.add(file7)
        files.add(file8)
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)
        fileAdapter = FilesAdapter(files, view.context)
        fileLayoutManager = GridLayoutManager(view.context, 1) as RecyclerView.LayoutManager
        fileRecyclerView = view.mediaRecycler
        fileRecyclerView.adapter = fileAdapter
        fileRecyclerView.layoutManager = fileLayoutManager
        return view
    }


}
