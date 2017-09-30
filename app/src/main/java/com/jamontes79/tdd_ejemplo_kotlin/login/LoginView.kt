package com.jamontes79.tdd_ejemplo_kotlin.login

/**
 * Created by jamontes79 on 30/09/2017.
 */
interface LoginView {

    fun showErrorMessageForUserPassword()

    fun showErrorMessageForMaxLoginAttempt()

    fun showLoginSuccessMessage()
}