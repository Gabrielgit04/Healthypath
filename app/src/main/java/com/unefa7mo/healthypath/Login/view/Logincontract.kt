package view

interface Logincontract {

    interface LoginView{
        fun showError(msgError:String?)
        fun showProgressBar()
        fun hideProgressBar()
        fun signIn()
        fun navigateToMain()
        fun navigateToRegister()
        fun navigateToForgotPassword()
    }

    interface LoginPresenter{
        fun attachView(view:LoginView)
        fun dettachView()
        fun dettachjob()
        fun isViewAttached():Boolean
        fun signInUserWithUsernameAndPassword(userName: String, password: String)
        fun checkEmptyFields(userName: String, password: String): Boolean
    }
}