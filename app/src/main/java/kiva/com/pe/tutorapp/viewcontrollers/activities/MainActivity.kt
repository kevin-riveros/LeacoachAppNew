package kiva.com.pe.tutorapp.viewcontrollers.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.viewcontrollers.fragments.FavoriteFragment
import kiva.com.pe.tutorapp.viewcontrollers.fragments.ProfileFragment
import kiva.com.pe.tutorapp.viewcontrollers.fragments.SearchFragment
import kiva.com.pe.tutorapp.models.SettingsAccount
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var titulo: TextView? =null


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Feed"
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        titulo = findViewById(R.id.tituloToolbar) as TextView

        val UserLogged = SettingsAccount(this)

        if (!UserLogged.didUserLoggedIn) {
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))

        } else {

            Toast.makeText(this, "Logged", Toast.LENGTH_SHORT).show()

        }
        navigation.selectedItemId = R.id.navigation_favorite
        titulo!!.text="Favorites"

    }

    private fun fragmentFor(item: MenuItem): Fragment {

        when (item.itemId) {
            R.id.navigation_favorite -> {
                titulo!!.text=getString(R.string.title_favorite)
                return FavoriteFragment()
            }
            R.id.navigation_search -> {
                titulo!!.text=getString(R.string.title_search)
                return SearchFragment()
            }
            R.id.navigation_profile -> {
                titulo!!.text=getString(R.string.title_profile)
                return ProfileFragment()

            }
        }
        return FavoriteFragment()

    }

    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true
        return supportFragmentManager.beginTransaction().replace(R.id.content, fragmentFor(item)).commit() > 0

    }

}
