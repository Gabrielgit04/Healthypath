package com.unefa7mo.healthypath.Login.PasswordRecover

interface PasswordRecoverContract {

    interface PasswordRecoverView{

        fun showError(msgError: String?)
        fun showProgress()
        fun hideProgress()
        fun recoverPassword()
        fun navigateToLogin()
    }
    interface PasswordRecoverPresenter{

        fun attachView(passwordRecoverView: PasswordRecoverView)
        fun detachView()
        fun detachJob()
        fun isViewAttached(): Boolean
        fun sendPasswordRecover(email: String)
    }

}