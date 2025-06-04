package com.unefa7mo.healthypath.Login

import android.app.Application
import com.unefa7mo.healthypath.Login.presentation.DependenceInjection.PresentationComponent
import com.unefa7mo.healthypath.Login.presentation.DependenceInjection.PresentationModule
import com.unefa7mo.healthypath.Login.presentation.DependenceInjection.DaggerPresentationComponent



class LoginApp: Application() {


    private var appComponent: PresentationComponent? = null

    override fun onCreate() {
        super.onCreate()

        appComponent= DaggerPresentationComponent
            .builder()
            .presentationModule(PresentationModule())
            .build()
    }
    fun getAppComponet(): PresentationComponent? = appComponent
}