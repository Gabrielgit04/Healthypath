package com.unefa7mo.healthypath.Login.interactors

interface SignUpInteractor {

    interface RegisterCallBack{

        fun onRegisterSucess()
        fun onRegisterFailure(errorMsg:String)

    }

    fun signUp(nombreusuario:String,email: String,password:String, listener:RegisterCallBack)

}