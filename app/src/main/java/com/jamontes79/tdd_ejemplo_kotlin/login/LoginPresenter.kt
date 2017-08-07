package com.jamontes79.tdd_ejemplo_kotlin.login

/**
 * Created by jamontes79 on 31/07/2017.
 */
class LoginPresenter
{
    var currentLoginAttempt = 0
    val  MAX_LOGIN_ATTEMPT = 3
    val  USER = "user"
    val  PASSWORD = "password"

    fun  newLoginAttempt(): Int = ++currentLoginAttempt

    fun  isLoginAttemptExceeded(): Boolean = currentLoginAttempt >= MAX_LOGIN_ATTEMPT
    fun  checkUserPassword(user: String, password: String) : Boolean {
        if (isLoginAttemptExceeded()) {
           return  false
        } else if (user == USER && password == PASSWORD) {
            return true
        } else {
            newLoginAttempt()
            return false
        }
    }

}