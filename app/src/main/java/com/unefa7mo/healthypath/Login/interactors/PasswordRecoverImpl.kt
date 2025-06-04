package com.unefa7mo.healthypath.Login.interactors

import com.google.firebase.auth.FirebaseAuth
import com.unefa7mo.healthypath.Login.PasswordRecover.PasswordRecoverException
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class PasswordRecoverImpl: PasswordRecover {
    override suspend fun sendPasswordResetEmail(email: String): Unit= suspendCancellableCoroutine { continuation ->
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
            if (it.isSuccessful){
                continuation.resume(Unit)
            }else{
                continuation.resumeWithException(PasswordRecoverException(it.exception?.message!!))
            }
        }

    }
}