package com.unefa7mo.healthypath.appViews

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.Login.PasswordRecover.PasswordRecoverActivity
import com.unefa7mo.healthypath.chatbot.ChatbotActivity
import view.MainActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val currentUser = FirebaseAuth.getInstance().currentUser
        findViewById<TextView>(R.id.user_name).text =
            currentUser?.displayName ?: getString(R.string.mi_perfil)
        findViewById<TextView>(R.id.user_email).text =
            currentUser?.email ?: getString(R.string.nav_perfil)

        findViewById<ImageButton>(R.id.backbutton).setOnClickListener {
            finish()
        }

        findViewById<LinearLayout>(R.id.row_password).setOnClickListener {
            startActivity(Intent(this, PasswordRecoverActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.row_logout).setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.selectedItemId = R.id.nav_perfil
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_perfil -> true
                R.id.nav_home -> {
                    startActivity(Intent(this, FirstMainActivity::class.java))
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
}