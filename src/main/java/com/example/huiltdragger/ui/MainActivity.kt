package com.example.huiltdragger.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.huiltdragger.R
import com.example.huiltdragger.ui.apdapter.EmployeeAdapter
import com.example.huiltdragger.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.error_message.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), EmployeeAdapter.CallbackInterface {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: EmployeeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapter = EmployeeAdapter(this)
        rvEmployees.layoutManager = LinearLayoutManager(this)
        rvEmployees.adapter = adapter

        init()
        setToolbar()

        mainViewModel.res.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progress.visibility = View.GONE
                    rvEmployees.visibility = View.VISIBLE
                    error_message.visibility =View.GONE
                    nointernet_message.visibility = View.GONE
                    it.data.let { res ->
                        if (res?.status == "success") {
                            res.data?.let { it1 -> adapter.submitList(it1) }
                        } else {
                            Toast.makeText(this, "Status = false", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                Status.LOADING -> {
                    progress.visibility = View.VISIBLE
                    rvEmployees.visibility = View.GONE
                    nointernet_message.visibility = View.GONE

                }
                Status.ERROR -> {
                    progress.visibility = View.GONE
                    rvEmployees.visibility = View.GONE
                    nointernet_message.visibility = View.VISIBLE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

                }
            }
        })

    }

    private fun setToolbar() {
        title = ""
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.home -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun init() {

        button_retry.setOnClickListener(clickListener)

    }

    val clickListener = View.OnClickListener {view ->

        when (view.getId()) {
            R.id.button_retry -> {

            }
        }
    }

    override fun passDataCallback(message: String) {
        Toast.makeText(this, "${message}", Toast.LENGTH_SHORT).show()
    }

}