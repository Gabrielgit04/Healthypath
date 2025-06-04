package com.unefa7mo.healthypath.appViews

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.activityphysique.PhysiqueActivity
import com.unefa7mo.healthypath.chatbot.ChatbotActivity
import com.unefa7mo.healthypath.dream.DreamActivity
import com.unefa7mo.healthypath.nutrition.NutritionViewActivity

class FirstMainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first_main)
        //Ir a activity de nutricion
        val goNext = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.secondtouch)
        goNext.setOnClickListener {
            val intent = Intent(this, NutritionViewActivity::class.java)
            startActivity(intent)
        }
        //Ir a activity de actividad fisica
        val gophysique = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.treetouch)
        gophysique.setOnClickListener {
            val intent = Intent(this, PhysiqueActivity::class.java)
            startActivity(intent)
        }
        //Ir a activity de sueño
        val godream = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.fourtouch)
        godream.setOnClickListener {
            val intent = Intent(this, DreamActivity::class.java)
            startActivity(intent)
        }
//Ir a activity de chatbot

        fun iralChat(){
            val goChat = findViewById<TextView>(R.id.textchat)
            val goChatImg  = findViewById<ImageView>(R.id.imgchat)
            val goChatBox = findViewById<LinearLayout>(R.id.boxchat)

            goChat.setOnClickListener {
                val intent = Intent(this, ChatbotActivity::class.java)
                startActivity(intent)
            }
            goChatImg.setOnClickListener {
                val intent = Intent(this, ChatbotActivity::class.java)
                startActivity(intent)
            }

            goChatBox.setOnClickListener {
                val intent = Intent(this, ChatbotActivity::class.java)
                startActivity(intent)
            }

        }
//
        iralChat()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FirstMainActivity", "onDestroy")
    }


}