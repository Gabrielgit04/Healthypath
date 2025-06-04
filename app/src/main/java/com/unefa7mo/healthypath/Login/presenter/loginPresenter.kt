package com.unefa7mo.healthypath.Login.presenter

import com.unefa7mo.healthypath.Login.exceptions.FirebaseLoginException
import interactors.SignInInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import view.Logincontract
import kotlin.coroutines.CoroutineContext
import javax.inject.Inject


class LoginPresenter @Inject constructor(private val signInInteractor:  SignInInteractor): Logincontract.LoginPresenter, CoroutineScope {

    var view:Logincontract.LoginView? = null

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun attachView(view: Logincontract.LoginView) {
        this.view= view
    }

    override fun dettachView() {
        view= null
    }

    override fun dettachjob() {
        coroutineContext.cancel()
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun signInUserWithUsernameAndPassword(userName: String, password: String) {
        launch {
            view?.showProgressBar()

            try {
                signInInteractor?.signInWithEmailAndPassword(userName,password)
                
                if(isViewAttached()) {
                    view?.hideProgressBar()
                    view?.navigateToMain()
                }

            }catch (e:FirebaseLoginException){
                view?.showError(e.message)
                view?.hideProgressBar()
            }

        }
    }


    override fun checkEmptyFields(userName: String, password: String): Boolean {
        return userName.isEmpty() || password.isEmpty()
    }
}