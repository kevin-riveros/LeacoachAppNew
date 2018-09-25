package kiva.com.pe.tutorapp.viewcontrollers.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.SettingsAccount

class LoginActivity : AppCompatActivity() {

    private var userRol: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnLogIn = findViewById<Button>(R.id.loginButton)

        //userRol = "Tutor"
        userRol = "Alumno"

        btnLogIn.setOnClickListener { view ->

            if (userRol.equals("Alumno")) {
                val settingsLogin = SettingsAccount(view.context)
                settingsLogin.didUserLoggedIn = true
                //startActivity(Intent(this,MainActivity::class.java))
                Toast.makeText(this, "Tu rol es: ${userRol}", Toast.LENGTH_SHORT).show()
                finish()


            } else {

                Toast.makeText(this, "Tu rol es: ${userRol}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
