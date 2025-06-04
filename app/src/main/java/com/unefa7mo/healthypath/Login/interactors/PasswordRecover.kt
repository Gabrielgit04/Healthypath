package com.unefa7mo.healthypath.Login.interactors

interface PasswordRecover {

    suspend fun sendPasswordResetEmail(email: String)
}