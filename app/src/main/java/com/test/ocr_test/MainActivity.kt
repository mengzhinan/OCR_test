package com.test.ocr_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.test.ocrlib.CaptureActivity
import com.test.ocrlib.FileCopyHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, CaptureActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
    }
}
