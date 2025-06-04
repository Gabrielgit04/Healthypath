package com.unefa7mo.healthypath.chatbot

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.lifecycle.ViewModelProvider
import com.unefa7mo.healthypath.Login.PasswordRecover.ui.theme.HealthypathTheme



class ChatbotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val chatViewModel= ViewModelProvider(this)[ChatViewModel::class.java]
        setContent{
            Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
                Chatpage(modifier= Modifier.padding(innerPadding), chatViewModel)


            }
        }
    }
}

