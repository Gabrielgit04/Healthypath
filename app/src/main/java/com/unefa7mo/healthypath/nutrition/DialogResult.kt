package com.unefa7mo.healthypath.nutrition

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.unefa7mo.healthypath.R



class DialogResult : DialogFragment() {

    lateinit var myVist: View

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val resultado = arguments?.getDouble("imcResult")

        super.onCreateDialog(savedInstanceState)
        myVist = requireActivity().layoutInflater.inflate(R.layout.activity_dialog_result, null)
        val myResult = myVist.findViewById<TextView>(R.id.result)

        myResult.text = resultado.toString()

        return AlertDialog.Builder(requireContext()).setView(myVist).setCancelable(false).setPositiveButton("Salir", DialogInterface.OnClickListener{ dialog, which ->
                dismiss()}).create()

    }

}




