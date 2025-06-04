package com.unefa7mo.healthypath.Login.presenter

import com.unefa7mo.healthypath.Login.PasswordRecover.PasswordRecoverContract
import com.unefa7mo.healthypath.Login.PasswordRecover.PasswordRecoverException
import com.unefa7mo.healthypath.Login.interactors.PasswordRecover
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PasswordRecoverPresenter(interactors: PasswordRecover): PasswordRecoverContract.PasswordRecoverPresenter, CoroutineScope{

    var view: PasswordRecoverContract.PasswordRecoverView?= null
    var interactors: PasswordRecover?= null

    var job=Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    init {
        this.interactors = interactors
    }

    override fun attachView(passwordRecoverView: PasswordRecoverContract.PasswordRecoverView) {
        this.view= passwordRecoverView
    }

    override fun detachView() {
        view=null
    }

    override fun detachJob() {
        coroutineContext.cancel()
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun sendPasswordRecover(email: String) {

        launch {
            try {
                view?.showProgress()
                interactors?.sendPasswordResetEmail(email)
                view?.hideProgress()
                view?.navigateToLogin()
            }catch (e: PasswordRecoverException){
                view?.hideProgress()
                view?.showError(e.message)
            }
        }
    }



}