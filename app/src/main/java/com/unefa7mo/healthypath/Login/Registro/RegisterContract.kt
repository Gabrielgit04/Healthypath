package Registro

import android.telephony.SignalStrengthUpdateRequest

interface RegisterContract {

    interface RegisterView{

        fun navigateToMain()
        fun SignUp()
        fun showProgress()
        fun hideProgress()
        fun showError(error:String)
    }

    interface RegisterPresenter {

        fun attachView(View: RegisterView)
        fun isViewAttached(): Boolean
        fun detachView()
        fun checkEmptyName(nombreusuario: String): Boolean
        fun checkValidEmail(email: String): Boolean
        fun checkEmptyPasswords(pw1: String, pw2: String): Boolean
        fun checkPasswordsMatch(pw1: String, pw2: String): Boolean
        fun signUp(nombreusuario: String, email: String, password: String)

    }


}