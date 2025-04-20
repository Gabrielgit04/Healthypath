package com.unefa7mo.healthypath.activityphysique.dialogscontents.dialoresultpxg

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.unefa7mo.healthypath.R

class DialogResultPxG : DialogFragment() {

    lateinit var myVist: View

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val requerimiento = arguments?.getInt("requerimiento")

        super.onCreateDialog(savedInstanceState)
        myVist = requireActivity().layoutInflater.inflate(R.layout.activity_resultpxg_dialog, null)

        val resultVist = myVist.findViewById<TextView>(R.id.resultpxg)
        resultVist.text = requerimiento.toString()+"gr"


        return AlertDialog.Builder(requireContext()).setView(myVist).setCancelable(false).setPositiveButton("Salir", DialogInterface.OnClickListener{ dialog, which ->
            dismiss()}).create()

    }

}
