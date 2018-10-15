package com.jakeattard.greengoldchat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_camera)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
                .replace(R.id.container, LiveCameraFragment.newInstance())
                .commit()
    }

}
