package com.unefa7mo.healthypath.dream

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.appViews.FirstMainActivity

class DreamActivity : AppCompatActivity() {
    private lateinit var backbutton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dream)
        backbutton = findViewById<ImageButton>(R.id.backbutton)
        volver()
        }

    fun volver() {

        backbutton.setOnClickListener {
            val intent = Intent(this, FirstMainActivity::class.java)
            startActivity(intent)
        }
    }

    }