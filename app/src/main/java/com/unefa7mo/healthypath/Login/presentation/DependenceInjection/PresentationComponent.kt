package com.unefa7mo.healthypath.Login.presentation.DependenceInjection

import dagger.Component
import view.MainActivity
import javax.inject.Singleton

@Component(modules = [PresentationModule::class])


@Singleton
interface PresentationComponent {
    fun inject(mainActivity: MainActivity )

}