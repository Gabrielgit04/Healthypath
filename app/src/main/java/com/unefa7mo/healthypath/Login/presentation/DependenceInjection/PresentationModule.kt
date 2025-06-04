package com.unefa7mo.healthypath.Login.presentation.DependenceInjection

import com.unefa7mo.healthypath.Login.interactors.SignInInteractorImpl
import dagger.Module
import dagger.Provides
import interactors.SignInInteractor


@Module

class PresentationModule {

    @Provides
    fun provideSignIn(): SignInInteractor = SignInInteractorImpl()
    }

