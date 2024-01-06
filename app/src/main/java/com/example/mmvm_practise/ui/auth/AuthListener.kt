package com.example.mmvm_practise.ui.auth

import com.example.mmvm_practise.data.Network.Response.UserDetail

interface AuthListener {
    fun onStarted()
    fun onSuccess(firstName: UserDetail?)
    fun onFailed(message:String)
    fun showMessage(message: String)
}