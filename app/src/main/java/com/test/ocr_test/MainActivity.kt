package com.test.ocr_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.test.ocrlib.FileCopyHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "${FileCopyHelper.copyChiToSDCard(this)}", Toast.LENGTH_SHORT).show()
    }
}
