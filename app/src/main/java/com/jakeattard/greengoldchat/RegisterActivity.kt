package com.jakeattard.greengoldchat

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRegister.setOnClickListener {
            performRegister()
        }
        loginTextViewRegister.setOnClickListener {
            // Launch the login activity screen
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
     }

        imgRegisterBtn.setOnClickListener {
            Log.d("RegisterActivity", "Try to show photo selector")

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode ==0 && resultCode == Activity.RESULT_OK && data != null) {
            // Checking what the selected image was
            Log.d("RegisterActivity", "Photo was selected")

            val uri = data.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)

            val bitmapDrawable = BitmapDrawable(bitmap)
            imgRegisterBtn.setBackgroundDrawable(bitmapDrawable)
        }
    }

    private fun performRegister(){
        val username = usernameRegisterScrn.text.toString()
        val email = emailRegisterScrn.text.toString()
        val password = passwordRegisterScrn.text.toString()

        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter text in email/password", Toast.LENGTH_SHORT).show()
            return
        }

        // Firebase Authentication
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{
                    if (!it.isSuccessful) return@addOnCompleteListener

                    // else if successful
                    Log.d("Main", "Successfully created user with uid: ${it.result?.user?.uid}")
                }
                .addOnFailureListener{
                    Log.d("Main", "Failed to create user: ${it.message}")
                    Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
                }
    }
}
