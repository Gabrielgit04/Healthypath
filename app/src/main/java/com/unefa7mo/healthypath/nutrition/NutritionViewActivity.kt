package com.unefa7mo.healthypath.nutrition


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.appViews.FirstMainActivity

class NutritionViewActivity : AppCompatActivity() {
    private lateinit var backbutton: ImageButton
    private lateinit var peso: EditText
    private lateinit var altura: EditText
    private lateinit var submit: androidx.appcompat.widget.AppCompatButton
    private lateinit var texto: TextView
    private lateinit var man: androidx.cardview.widget.CardView
    private lateinit var woman: androidx.cardview.widget.CardView
    private lateinit var description: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_view)

        backbutton = findViewById(R.id.backbutton)
        peso = findViewById(R.id.peso)
        altura = findViewById(R.id.altura)
        submit = findViewById(R.id.submit)
        texto = findViewById(R.id.datos)
        man = findViewById(R.id.man)
        woman = findViewById(R.id.woman)
        description = findViewById(R.id.description)

        fun volver() {

            backbutton.setOnClickListener {
                val intent = Intent(this, FirstMainActivity::class.java)
                startActivity(intent)
            }
        }


        fun calcular() {
            submit.setOnClickListener {

                val dialog = DialogResult()
                dialog.show(supportFragmentManager, "DialogResult")

            }

        }

        val presionar = true
        fun clickdescription(presionar: Boolean, lines: Int = Int.MAX_VALUE) {
            description.setOnClickListener {
                if (presionar) {
                    description.maxLines = lines
                }
            }

        }

        fun manChange() {
            man.setOnClickListener {
                man.setCardBackgroundColor(resources.getColor(R.color.pressbutton))
            }
        }

        fun womanChange() {
            woman.setOnClickListener {
                woman.setCardBackgroundColor(resources.getColor(R.color.pressbutton))
            }
        }

            calcular()
            volver()
            clickdescription(presionar)
            manChange()
            womanChange()



    }
}






