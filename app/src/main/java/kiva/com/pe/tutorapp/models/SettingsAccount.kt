package kiva.com.pe.tutorapp.models

import android.content.Context
import android.preference.PreferenceManager


class SettingsAccount(val context: Context) {

    companion object {
        val didUserLoggedIn = "didUserLoggedIn"
    }

    val preferences = PreferenceManager
            .getDefaultSharedPreferences(context)

    var didUserLoggedIn: Boolean = preferences.getBoolean(Companion.didUserLoggedIn, false)
        set(value) = preferences.edit().putBoolean(Companion.didUserLoggedIn, value).apply()

    var shouldUserLoggedIn: Boolean = !didUserLoggedIn
        set(value) {
            shouldUserLoggedIn = !value
        }

}