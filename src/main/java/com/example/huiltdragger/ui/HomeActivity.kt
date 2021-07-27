package com.example.huiltdragger.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.huiltdragger.R
import com.example.huiltdragger.ui.insert.InsertActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        init()

    }
    private fun init(){
        setToolbar()
        floatingActionButton2.setOnClickListener(this)


    }

    private fun setToolbar() {
        title = "Home"
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.getId()) {
                R.id.floatingActionButton2 -> goToinsertActivity()

            }
        }
    }

    private fun goToinsertActivity(){
       val intent = Intent(this@HomeActivity,InsertActivity::class.java)
        startActivity(intent)
    }
}