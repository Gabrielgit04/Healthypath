package com.unefa7mo.healthypath.Login.Registro

import Registro.RegisterContract
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.unefa7mo.healthypath.Login.base.BaseActivity
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.Login.interactors.SignUpInteractorImpl
import com.unefa7mo.healthypath.appViews.FirstMainActivity
import view.MainActivity

class RegisterActivity : BaseActivity(), RegisterContract.RegisterView {

    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)
        presenter = RegisterPresenter(SignUpInteractorImpl())
        presenter.attachView(this)
        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            SignUp()
        }

    }

    override fun getLayout(): Int {
        return R.layout.registro
    }

    override fun navigateToMain() {
        val intent = Intent(this, FirstMainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun SignUp() {
        val nombreU = findViewById<TextView>(R.id.nombreusuario)
        val emailU = findViewById<TextView>(R.id.correo)
        val password1U = findViewById<TextView>(R.id.password)
        val password2U = findViewById<TextView>(R.id.password2)
         val nombreusuario:String= nombreU.text.toString().trim()
         val email:String= emailU.text.toString().trim()
         val password:String= password1U.text.toString().trim()
         val password2:String= password2U.text.toString().trim()

        if (presenter.checkEmptyName(nombreusuario)){

            nombreU.error= "el nombre esta vacio"
            return
        }

        if(! presenter.checkValidEmail(email)){
            emailU.error= "el correo es invalido"
            return
        }

        if(presenter.checkEmptyPasswords(password,password2)){
            password1U.error= "campo vacio"
            password2U.error= "campo vacio"
            return
        }

        if (!presenter.checkPasswordsMatch(password,password2)){

            password1U.error= "contrasenas no iguales"
            password2U.error= "contrasenas no iguales"
            return
        }

        presenter.signUp(nombreusuario,email,password)

    }

    override fun showProgress() {
        val login = findViewById<Button>(R.id.login)
        val  carga = findViewById<ProgressBar>(R.id.carga)
        carga.visibility = View.VISIBLE
        login.visibility = View.GONE

    }

    override fun hideProgress() {
        val login = findViewById<Button>(R.id.login)
        val  carga = findViewById<ProgressBar>(R.id.carga)
        carga.visibility = View.GONE
        login.visibility = View.VISIBLE
    }

    override fun showError(errormsg:String) {
        toast(this,errormsg)
    }

    override fun onDetachedFromWindow(){
        super.onDetachedFromWindow()
        presenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}