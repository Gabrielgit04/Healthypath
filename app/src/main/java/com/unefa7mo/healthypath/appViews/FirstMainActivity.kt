package com.unefa7mo.healthypath.appViews

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.unefa7mo.healthypath.R

class FirstMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first_main)
        Log.d("FirstMainActivity","onCreate")

        }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FirstMainActivity","onDestroy")
        }

    }
