package com.udacity.shoestore.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel

const val MIN_SIZE_USERNAME = 5
const val MIN_SIZE_PASSWORD = 5
/**
 * View model for Login to register and login user against rules/database/authentication instance
 */
class LoginViewModel(application: Application) : AndroidViewModel(application) {
    /**
     * Check register information against rules
     * @return true if register credentials are valid.
     */
    fun register(login: String, password: String): Boolean {
        return login.length > MIN_SIZE_USERNAME && password.length > MIN_SIZE_PASSWORD
    }
    /**
     * Check login information against database (not implemented in this project)
     * @return true if login credentials are valid.
     * TODO: Implement login checker if I know more about databases/authentication in Android
     */
    fun login(login: String, password: String): Boolean {
        return true
    }
}