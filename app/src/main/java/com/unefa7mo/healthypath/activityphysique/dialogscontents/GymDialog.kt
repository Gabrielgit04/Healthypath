package com.unefa7mo.healthypath.activityphysique.dialogscontents

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.unefa7mo.healthypath.R


class GymDialog: DialogFragment() {

    lateinit var  myView: View
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        super.onCreate(savedInstanceState)
        myView = requireActivity().layoutInflater.inflate(R.layout.activity_gym_dialog, null)
        return AlertDialog.Builder(requireContext()).setView(myView).setCancelable(false)
            .setPositiveButton("Salir", DialogInterface.OnClickListener{ dialog, which ->
                dismiss()
            }).create()

    }

}
