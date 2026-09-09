package com.unefa7mo.healthypath.Login.interactors

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore

class SignUpInteractorImpl: SignUpInteractor{

    override fun signUp(
        nombreusuario: String,
        email: String,
        password: String,
        listener: SignUpInteractor.RegisterCallBack) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful) {
                val uid = it.result?.user?.uid

                val profileUpdates: UserProfileChangeRequest = UserProfileChangeRequest.Builder()
                    .setDisplayName(nombreusuario)
                    .build()
                FirebaseAuth.getInstance().currentUser?.updateProfile(profileUpdates)?.addOnCompleteListener { profile ->
                    if (profile.isSuccessful) {
                        registrarUsuario(
                            uid = uid,
                            username = nombreusuario,
                            email = email,
                            listener = listener
                        )
                    } else {
                        listener.onRegisterFailure(profile.exception?.message ?: "Error al actualizar el perfil")
                    }
                }
            } else {
                listener.onRegisterFailure(it.exception?.message.toString())
            }
        }
    }

    private fun registrarUsuario(
        uid: String?,
        username: String,
        email: String,
        listener: SignUpInteractor.RegisterCallBack) {
        if (uid == null) {
            listener.onRegisterFailure("Error al obtener el id del usuario")
            return
        }
        val datos = hashMapOf(
            "id" to uid,
            "username" to username,
            "email" to email
        )
        FirebaseFirestore.getInstance()
            .collection("users")
            .document(uid)
            .set(datos)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    listener.onRegisterSucess()
                } else {
                    listener.onRegisterFailure(it.exception?.message ?: "Error al guardar en Firestore")
                }
            }
    }
}