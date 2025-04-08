package com.unefa7mo.healthypath.appViews

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.activityphysique.PhysiqueActivity
import com.unefa7mo.healthypath.nutrition.NutritionViewActivity

class FirstMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first_main)
        Log.d("FirstMainActivity", "onCreate")

        val goNext = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.secondtouch)
        goNext.setOnClickListener {
            val intent = Intent(this, NutritionViewActivity::class.java)
            startActivity(intent)
        }

        val gophysique = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.treetouch)
        gophysique.setOnClickListener {
            val intent = Intent(this, PhysiqueActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FirstMainActivity", "onDestroy")
    }


}