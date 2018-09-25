package kiva.com.pe.tutorapp.viewcontrollers.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.viewcontrollers.fragments.FeedFragment
import kiva.com.pe.tutorapp.viewcontrollers.fragments.ProfileFragment
import kiva.com.pe.tutorapp.viewcontrollers.fragments.TutorsFragment
import kiva.com.pe.tutorapp.models.SettingsAccount
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Feed"
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val UserLogged = SettingsAccount(this)

        if (!UserLogged.didUserLoggedIn) {
            Toast.makeText(this, "openlogin", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))


        } else {

            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show()

        }


    }

    private fun fragmentFor(item: MenuItem): Fragment {

        when (item.itemId) {
            R.id.navigation_home -> {
                supportActionBar?.title = getString(R.string.feed_title)
                return FeedFragment()
            }
            R.id.navigation_dashboard -> {
                supportActionBar?.title = getString(R.string.tutors_title)
                return TutorsFragment()
            }
            R.id.navigation_notifications -> {
                supportActionBar?.title = getString(R.string.profile_title)
                return ProfileFragment()

            }
        }
        return FeedFragment()

    }

    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true
        return supportFragmentManager.beginTransaction().replace(R.id.content, fragmentFor(item)).commit() > 0

    }

}
