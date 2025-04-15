package com.unefa7mo.healthypath.activityphysique

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.activityphysique.dialogscontents.AerobicDialog
import com.unefa7mo.healthypath.activityphysique.dialogscontents.CalisteniaDialog
import com.unefa7mo.healthypath.activityphysique.dialogscontents.DietaDialog
import com.unefa7mo.healthypath.activityphysique.dialogscontents.GymDialog
import com.unefa7mo.healthypath.appViews.FirstMainActivity

class PhysiqueActivity : AppCompatActivity() {


    private lateinit var aerobico: com.airbnb.lottie.LottieAnimationView
    private lateinit var dieta: com.airbnb.lottie.LottieAnimationView
    private lateinit var gym: com.airbnb.lottie.LottieAnimationView
    private lateinit var calistenia: com.airbnb.lottie.LottieAnimationView
    private lateinit var backbutton: ImageButton
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physique)

        calistenia = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.primercuadro)
        backbutton = findViewById<ImageButton>(R.id.backbutton)
        gym = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.segundocuadro)
        aerobico = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.tercercuadro)
        dieta = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.utlimocuadro)


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
            gym.setOnClickListener {
                val dialogOpentwo = GymDialog()
                dialogOpentwo.show(supportFragmentManager, "GymDialog")
            }
            aerobico.setOnClickListener {
                val dialogOpenthree = AerobicDialog()
                dialogOpenthree.show(supportFragmentManager, "AerobicoDialog")
            }
            dieta.setOnClickListener {
                val dialogOpenfour = DietaDialog()
                dialogOpenfour.show(supportFragmentManager, "DietaDialog")
            }

        }

        abriModales()
        volver()
        }





    }
