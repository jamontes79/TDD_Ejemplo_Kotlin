package com.jamontes79.tdd_ejemplo_kotlin.login

import org.junit.Assert
import org.junit.Test

/**
 * Created by jamontes79 on 31/07/2017.
 */
class LoginPresenterTest {
    @Test
    fun checkIfLoginAttemptIsExceeded() {

        val loginPresenter = LoginPresenter()
        Assert.assertEquals(1, loginPresenter.newLoginAttempt())
        Assert.assertEquals(2, loginPresenter.newLoginAttempt())
        Assert.assertEquals(3, loginPresenter.newLoginAttempt())
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded())
    }
    @Test
    fun checkIfLoginAttemptIsNotExceeded(){
        val loginPresenter = LoginPresenter()
        Assert.assertFalse(loginPresenter.isLoginAttemptExceeded())
    }

    @Test
    fun checkUserAndPasswordIsCorrect(){
        val loginPresenter = LoginPresenter()
        Assert.assertTrue(loginPresenter.checkUserPassword("user", "password"))
    }
    @Test
    fun checkUserAndPasswordIsNotCorrect(){
        val loginPresenter = LoginPresenter()
        Assert.assertFalse(loginPresenter.checkUserPassword("user1", "password1"))
    }

    @Test
    fun checkIfLoginAttemptIsExceededWithMessage(){
        val loginPresenter = LoginPresenter()
        loginPresenter.checkUserPassword("user1", "password1")
        loginPresenter.checkUserPassword("user1", "password1")
        loginPresenter.checkUserPassword("user1", "password1")
        loginPresenter.checkUserPassword("user1", "password1")
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded())
    }
}