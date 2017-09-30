package com.jamontes79.tdd_ejemplo_kotlin.login

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import com.jamontes79.tdd_ejemplo_kotlin.R

class LoginActivity : AppCompatActivity(), LoginView {

    private var loginPresenter: LoginPresenter? = null
    private var txtUserName: EditText? = null
    private var txtPassword: EditText? = null
    private var btnLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initializePresenter()
        initializeViews()
    }


    private fun initializePresenter() {
        loginPresenter = LoginPresenter(this)
    }

    private fun initializeViews() {
        txtUserName = findViewById(R.id.txt_user_name) as EditText
        txtPassword = findViewById(R.id.txt_password) as EditText
        btnLogin = findViewById(R.id.btn_login) as Button
        btnLogin!!.setOnClickListener {
            loginPresenter!!.checkUserPassword(txtUserName!!.text.toString().trim(),
                    txtPassword!!.text.toString().trim())
        }
    }

    override fun showErrorMessageForUserPassword() {
        Snackbar.make(txtPassword!!, R.string.error_user_password, Snackbar.LENGTH_LONG).show()
    }

    override fun showErrorMessageForMaxLoginAttempt() {
        Snackbar.make(btnLogin!!, R.string.error_max_login_attempt, Snackbar.LENGTH_LONG).show()
    }

    override fun showLoginSuccessMessage() {
        Snackbar.make(btnLogin!!, R.string.login_ok, Snackbar.LENGTH_LONG).show()
    }
}
