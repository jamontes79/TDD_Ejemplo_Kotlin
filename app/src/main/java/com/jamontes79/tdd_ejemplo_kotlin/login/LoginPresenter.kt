package com.jamontes79.tdd_ejemplo_kotlin.login

/**
 * Created by jamontes79 on 31/07/2017.
 */
class LoginPresenter(private val loginView: LoginView) {
    companion object {
        private val MAX_LOGIN_ATTEMPT = 3
        private val USER = "user"
        private val PASSWORD = "password"
    }
    private var currentLoginAttempt = 0
    fun newLoginAttempt(): Int {
        return ++currentLoginAttempt
    }

    val isLoginAttemptExceeded: Boolean
        get() = currentLoginAttempt >= MAX_LOGIN_ATTEMPT

    fun checkUserPassword(user: String, password: String): Boolean {
        var ret = true
        if (isLoginAttemptExceeded) {
            loginView.showErrorMessageForMaxLoginAttempt()
            ret = false
        } else if (user == USER && password == PASSWORD) {
            loginView.showLoginSuccessMessage()
        } else {
            loginView.showErrorMessageForUserPassword()
            ret = false
            newLoginAttempt()
        }
        return ret
    }



}
