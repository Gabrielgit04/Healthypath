package com.unefa7mo.healthypath.activityphysique.dialogscontents

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.unefa7mo.healthypath.R


class CalisteniaDialog: DialogFragment() {

    lateinit var  myView: View
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        super.onCreate(savedInstanceState)
        myView = requireActivity().layoutInflater.inflate(R.layout.activity_calistenia_dialog, null)
        tablaRutina()
        return AlertDialog.Builder(requireContext()).setView(myView).setCancelable(false)
            .setPositiveButton("Salir", DialogInterface.OnClickListener{ dialog, which ->
                dismiss()
            }).create()

        }
    lateinit var tabla: TableLayout
    fun tablaRutina(){
        tabla = myView.findViewById<TableLayout>(R.id.tablaex)
        val fila1 = TableRow(requireContext())
        val columna1 = TextView(requireContext())
        columna1.text = "Lunes"
        fila1.addView(columna1)
        tabla.addView(fila1)

    }

}




