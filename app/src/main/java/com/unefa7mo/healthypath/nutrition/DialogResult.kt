package com.unefa7mo.healthypath.nutrition

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.unefa7mo.healthypath.R

class DialogResult : DialogFragment() {
        @SuppressLint("SuspiciousIndentation")
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val rootView: View = inflater.inflate(R.layout.activity_dialog_result, container, false)
                return rootView
    }


    }
