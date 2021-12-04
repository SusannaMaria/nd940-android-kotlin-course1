package com.udacity.shoestore.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    fun login(login: String, password: String): Boolean {
        return login.length > 5 && password.length > 5
    }
}