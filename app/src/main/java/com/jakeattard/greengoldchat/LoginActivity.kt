package com.jakeattard.greengoldchat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtnScrn.setOnClickListener {
            val email = emailLoginScrn.text.toString()
            val password = passwordLoginScrn.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener{
                        if (!it.isSuccessful) return@addOnCompleteListener
                    }
        }

        registerTextViewScrn.setOnClickListener {
            finish()
        }
    }
}