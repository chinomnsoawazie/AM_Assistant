package com.example.amassistant

import android.app.Activity
import android.os.Bundle
import android.util.Log

class SignupViewModel : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun createUser (email: String, password: String) {
        Log.d("SignupInfo", "Email: ${email}" + "Password: ${password}")

    }
}