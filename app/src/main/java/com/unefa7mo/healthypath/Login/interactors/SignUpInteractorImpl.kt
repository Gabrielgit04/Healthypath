package com.unefa7mo.healthypath.Login.interactors

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class SignUpInteractorImpl: SignUpInteractor{

    override fun signUp(
        nombreusuario: String,
        email: String,
        password: String,
        listener: SignUpInteractor.RegisterCallBack) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful) {

                val profileUpdates: UserProfileChangeRequest = UserProfileChangeRequest.Builder()
                    .setDisplayName(nombreusuario)
                    .build()
                FirebaseAuth.getInstance().currentUser?.updateProfile(profileUpdates)?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        listener.onRegisterSucess()
                    }
                }
            } else {
                listener.onRegisterFailure(it.exception?.message.toString())
            }
        }

    }
}
