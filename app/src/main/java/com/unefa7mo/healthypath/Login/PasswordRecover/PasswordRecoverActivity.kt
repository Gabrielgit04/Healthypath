package com.unefa7mo.healthypath.Login.PasswordRecover

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.Login.base.BaseActivity
import com.unefa7mo.healthypath.Login.interactors.PasswordRecoverImpl
import com.unefa7mo.healthypath.Login.presenter.PasswordRecoverPresenter
import view.MainActivity

class PasswordRecoverActivity : BaseActivity(), PasswordRecoverContract.PasswordRecoverView {

    lateinit var presenter: PasswordRecoverPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter=PasswordRecoverPresenter(PasswordRecoverImpl())
        presenter.attachView(this)
        val botonRecuperar = findViewById<Button>(R.id.botonRecuperar)
        botonRecuperar.setOnClickListener {
            recoverPassword()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_password_recover
    }

    override fun showError(msgError: String?) {
        toast(this,msgError)
    }

    override fun showProgress() {
        val progressBarRecover = findViewById<ProgressBar>(R.id.progressBarRecuperar)
        val botonRecuperar = findViewById<Button>(R.id.botonRecuperar)

        progressBarRecover.visibility = View.VISIBLE
        botonRecuperar.visibility = View.GONE
    }

    override fun hideProgress() {
            val progressBarRecover = findViewById<ProgressBar>(R.id.progressBarRecuperar)
            val botonRecuperar = findViewById<Button>(R.id.botonRecuperar)

            progressBarRecover.visibility = View.GONE
            botonRecuperar.visibility = View.VISIBLE
    }

    override fun recoverPassword() {
        val editTextRecuperar = findViewById<EditText>(R.id.editRecuperar)
        val email: String = editTextRecuperar.text.trim().toString()
        if (!email.isEmpty()) presenter.sendPasswordRecover(email) else toast(this, "ingrese un correo")
    }

    override fun navigateToLogin() {
        startActivity(Intent(this, MainActivity::class.java))
       toast(this,"Correo enviado")
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
        presenter.detachJob()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detachView()
        presenter.detachJob()
    }

}