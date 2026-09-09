package com.unefa7mo.healthypath.appViews

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.activityphysique.PhysiqueActivity
import com.unefa7mo.healthypath.chatbot.ChatbotActivity
import com.unefa7mo.healthypath.dream.DreamActivity
import com.unefa7mo.healthypath.nutrition.NutritionViewActivity

class FirstMainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_main)

        bottomNav = findViewById(R.id.bottom_nav)
        setupBottomNav()

        navegarPasajero(R.id.secondView, NutritionViewActivity::class.java)
        navegarPasajero(R.id.secondtouch, NutritionViewActivity::class.java)
        navegarPasajero(R.id.thirdView, PhysiqueActivity::class.java)
        navegarPasajero(R.id.treetouch, PhysiqueActivity::class.java)
        navegarPasajero(R.id.fourthView, DreamActivity::class.java)
        navegarPasajero(R.id.fourtouch, DreamActivity::class.java)
    }

    override fun onResume() {
        super.onResume()
        bottomNav.selectedItemId = R.id.nav_home
    }

    private fun setupBottomNav() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_perfil -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                R.id.nav_chatbot -> {
                    startActivity(Intent(this, ChatbotActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun navegarPasajero(id: Int, destino: Class<*>) {
        val view = findViewById<android.view.View>(id) ?: return
        if (view is ImageButton || view is com.airbnb.lottie.LottieAnimationView) {
            view.setOnClickListener {
                startActivity(Intent(this, destino))
            }
        }
    }
}