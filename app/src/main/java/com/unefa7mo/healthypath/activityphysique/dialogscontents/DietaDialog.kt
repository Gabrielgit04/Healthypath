package com.unefa7mo.healthypath.activityphysique.dialogscontents

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.activityphysique.dialogscontents.dialoresultpxg.DialogResultPxG


class DietaDialog: DialogFragment() {

    private lateinit var pesoxg: EditText
    private lateinit var calcularpxg: Button
    lateinit var myView: View
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        super.onCreate(savedInstanceState)
        myView = requireActivity().layoutInflater.inflate(R.layout.activity_resultpxg_dialog, null)
        calcularkgxp()
        return AlertDialog.Builder(requireContext()).setView(myView).setCancelable(false)
            .setPositiveButton("Salir", DialogInterface.OnClickListener { dialog, which ->
                dismiss()
            }).create()

    }
        fun calcularkgxp(){
        pesoxg = myView.findViewById(R.id.pesoxg)
        calcularpxg = myView.findViewById(R.id.calcularpxg)

        calcularpxg.setOnClickListener {
            val resultado = pesoxg.text.toString().toInt() * 2

            val sendtext = Bundle()
            sendtext.putInt("requerimiento", resultado)
            val dialog = DialogResultPxG()
            dialog.arguments = sendtext
            dialog.show(parentFragmentManager, "DialogResultPxG")



    }

    }


}