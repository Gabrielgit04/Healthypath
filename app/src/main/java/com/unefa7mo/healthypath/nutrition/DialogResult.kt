package com.unefa7mo.healthypath.nutrition

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.unefa7mo.healthypath.R



class DialogResult : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val result = arguments?.getDouble("imcResult")
        if (result == null) {
            return super.onCreateDialog(savedInstanceState)
        }
        val myVist = requireActivity().layoutInflater.inflate(R.layout.activity_dialog_result, null)
        val myResult = myVist.findViewById<TextView>(R.id.result)
        myResult.text = result.toString()
        return AlertDialog.Builder(requireContext()).setView(myVist).create()

        fun changeColor(){

            if (result < 18.5){
                val boxResult = myVist.findViewById<LinearLayout>(R.id.result)
                boxResult.setBackgroundResource(R.drawable.incorrect)
            }

            else if (result >= 18.5 && result <= 24.9){
                val boxResult = myVist.findViewById<LinearLayout>(R.id.result)
                boxResult.setBackgroundResource(R.drawable.correct)

            }
            else if (result >= 25 && result <= 29.9){
                val boxResult = myVist.findViewById<LinearLayout>(R.id.result)
                boxResult.setBackgroundResource(R.drawable.incorrect)
            }

        }

        fun closeDialog(){
            val accept = myVist.findViewById<TextView>(R.id.accept)
                accept.setOnClickListener {
                dismiss()
            }
        }

            changeColor()
            closeDialog()


            }
    }




