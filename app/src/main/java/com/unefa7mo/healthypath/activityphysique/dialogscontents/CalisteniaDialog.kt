package com.unefa7mo.healthypath.activityphysique.dialogscontents

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.unefa7mo.healthypath.R

class CalisteniaDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreate(savedInstanceState)
        val myView = requireActivity().layoutInflater.inflate(R.layout.activity_calistenia_dialog, null)
        return AlertDialog.Builder(requireContext()).setView(myView) .setCancelable(false).setPositiveButton("Salir", DialogInterface.OnClickListener(){ dialog, which ->
            dismiss()
        }).create()
        }



    }
