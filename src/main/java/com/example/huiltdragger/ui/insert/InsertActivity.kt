package com.example.huiltdragger.ui.insert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.huiltdragger.R

class InsertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        setToolbar()
    }

    private fun setToolbar() {
        title = "Insert Data"
    }
}