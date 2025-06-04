package view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.unefa7mo.healthypath.Login.PasswordRecover.PasswordRecoverActivity
import com.unefa7mo.healthypath.Login.base.BaseActivity
import com.unefa7mo.healthypath.Login.interactors.SignUpInteractor
import com.unefa7mo.healthypath.R
import com.unefa7mo.healthypath.Login.LoginApp
import com.unefa7mo.healthypath.Login.presenter.LoginPresenter
import com.unefa7mo.healthypath.appViews.FirstMainActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), Logincontract.LoginView{
    private lateinit var progressBar_SignIn: ProgressBar

    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as LoginApp).getAppComponet()?.inject(this)
        presenter.attachView(this)
        val empezar = findViewById<Button>(R.id.empezar)
        progressBar_SignIn = findViewById<ProgressBar>(R.id.progressBar_SignIn)
        empezar.setOnClickListener {
            signIn()
        }

        val botonRegistrarme = findViewById<Button>(R.id.registrarme)
        botonRegistrarme.setOnClickListener{
            navigateToRegister()
        }

        val forgottenPassword = findViewById<TextView>(R.id.forgottenPassword)
        forgottenPassword.setOnClickListener{
            navigateToForgotPassword()
        }
    }


    override fun getLayout(): Int {
        return R.layout.iniciosecion
    }

    override fun showError(msgError: String?) {
        Toast.makeText(this, msgError, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        progressBar_SignIn.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar_SignIn.visibility = View.GONE
    }

    override fun signIn() {
        val nomUser = findViewById<EditText>(R.id.UnombreUsuario)
        val passUser = findViewById<EditText>(R.id.Upassword)
        val userName = nomUser.text.toString().trim()
        val password = passUser.text.toString().trim()
        if (presenter.checkEmptyFields(userName,password)){
            toast(this,"Uno o dos campos vacios, no se puede ingresar")}
        else
        { presenter.signInUserWithUsernameAndPassword(userName,password)}

    }

    override fun navigateToMain() {
        val intent = Intent(this, FirstMainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun navigateToRegister() {
        startActivity(Intent(this, SignUpInteractor::class.java))
    }

    override fun navigateToForgotPassword() {
        startActivity(Intent(this, PasswordRecoverActivity::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dettachView()
        presenter.dettachjob()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.dettachView()
        presenter.dettachjob()
    }




}