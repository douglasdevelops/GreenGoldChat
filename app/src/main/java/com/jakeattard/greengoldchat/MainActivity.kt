package com.jakeattard.greengoldchat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRegister.setOnClickListener {
            val username = usernameRegisterScrn.text.toString()
            val email = emailRegisterScrn.text.toString()
            val password = passwordRegisterScrn.text.toString()
        }
        loginTextViewRegister.setOnClickListener {
            // Launch the login activity screen
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
     }
    }
}
