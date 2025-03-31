package com.unefa7mo.healthypath.nutrition


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.appViews.FirstMainActivity

class NutritionViewActivity : AppCompatActivity() {
    private lateinit var backbutton: ImageButton
    private lateinit var peso: EditText
    private lateinit var altura: EditText
    private lateinit var submit: androidx.appcompat.widget.AppCompatButton
    private lateinit var texto: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_view)

    }



    private fun initcomponents() {
        backbutton = findViewById(R.id.backbutton)
        peso = findViewById(R.id.peso)
        altura = findViewById(R.id.altura)
        submit = findViewById(R.id.submit)
        texto =findViewById(R.id.description)
    }

    }


