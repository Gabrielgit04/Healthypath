package com.unefa7mo.healthypath.activityphysique.dialogscontents

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.unefa7mo.healthypath.R

class CalisteniaDialog: DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val myView = requireActivity().layoutInflater.inflate(R.layout.activity_calistenia_dialog, null)
        val myDialog = AlertDialog.Builder(this.requireContext())

        myDialog.setView(myView)
        myDialog.create()
        myDialog.show()

    }

    fun abrirModal(){
    }
}