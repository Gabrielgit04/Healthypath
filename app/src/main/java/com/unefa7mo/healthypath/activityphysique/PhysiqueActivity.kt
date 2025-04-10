package com.unefa7mo.healthypath.activityphysique
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.activityphysique.dialogscontents.CalisteniaDialog
import com.unefa7mo.healthypath.appViews.FirstMainActivity

class PhysiqueActivity : AppCompatActivity() {

    private lateinit var calistenia: com.airbnb.lottie.LottieAnimationView
    private lateinit var backbutton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physique)

        calistenia = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.primercuadro)
        backbutton = findViewById<ImageButton>(R.id.backbutton)
        fun volver() {

            backbutton.setOnClickListener {
                val intent = Intent(this, FirstMainActivity::class.java)
                startActivity(intent)
            }
        }

        fun abriModales(){
            calistenia.setOnClickListener {
                val dialogOpen = CalisteniaDialog()
                dialogOpen.show(supportFragmentManager, "CalisteniaDialog")
            }
        }

        abriModales()
        volver()
        }





    }
