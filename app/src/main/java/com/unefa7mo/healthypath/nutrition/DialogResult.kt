package com.unefa7mo.healthypath.nutrition

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
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


            }
    }




