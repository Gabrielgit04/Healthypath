package com.unefa7mo.healthypath.Login.interactors

import com.google.firebase.auth.FirebaseAuth
import interactors.SignInInteractor
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import com.unefa7mo.healthypath.Login.exceptions.FirebaseLoginException

class SignInInteractorImpl: SignInInteractor {

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Unit=
        suspendCancellableCoroutine{ continuation ->
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {
               if(it.isSuccessful){
                   continuation.resume(Unit)
               }else{
                   continuation.resumeWithException(FirebaseLoginException(it.exception?.message))
               }
            }

        }

}

