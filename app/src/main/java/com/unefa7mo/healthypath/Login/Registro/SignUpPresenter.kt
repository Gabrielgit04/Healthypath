package com.unefa7mo.healthypath.Login.Registro

import Registro.RegisterContract
import androidx.core.util.PatternsCompat
import com.unefa7mo.healthypath.Login.interactors.SignUpInteractor

class RegisterPresenter(signUpInteractor: SignUpInteractor): RegisterContract.RegisterPresenter {

    var View: RegisterContract.RegisterView?= null
    var signUpInteractor: SignUpInteractor?= null

    init {
        this.signUpInteractor=signUpInteractor
    }


    override fun attachView(View: RegisterContract.RegisterView) {
        this.View= View
    }

    override fun isViewAttached(): Boolean {
        return View != null
    }

    override fun detachView() {
        View= null
    }

    override fun checkEmptyName(nombreusuario: String): Boolean {
        return nombreusuario.isEmpty()
    }

    override fun checkValidEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }


    override fun checkEmptyPasswords(pw1: String, pw2: String): Boolean {
        return pw1.isEmpty() or pw2.isEmpty()
    }

    override fun checkPasswordsMatch(pw1: String, pw2: String): Boolean {
        return pw1==pw2
    }

    override fun signUp(nombreusuario: String, email: String, password: String) {
        View?.showProgress()
        signUpInteractor?.signUp(nombreusuario,email,password,object : SignUpInteractor.RegisterCallBack{

            override fun onRegisterSucess() {
                View?.navigateToMain()
                View?.hideProgress()
            }

            override fun onRegisterFailure(errorMsg: String) {
                View?.showError(errorMsg)
                View?.hideProgress()
            }
        })
    }
}