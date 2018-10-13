package com.jakeattard.greengoldchat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtnScrn.setOnClickListener {
            val email = emailLoginScrn.text.toString()
            val password = passwordLoginScrn.text.toString()
        }

        registerTextViewScrn.setOnClickListener {
            finish()
        }
    }
}