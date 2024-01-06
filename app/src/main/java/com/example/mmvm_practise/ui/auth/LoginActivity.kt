package com.example.mmvm_practise.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.mmvm_practise.R
import com.example.mmvm_practise.data.Network.Response.UserDetail
import com.example.mmvm_practise.databinding.ActivityLoginBinding
import com.example.mmvm_practise.util.toast

class LoginActivity : AppCompatActivity(), AuthListener {
    lateinit var viewModel:AuthViewModel
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel= ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewModelL = viewModel
        viewModel.listener = this
        viewModel.context = this

    }

    override fun onStarted() {
//        viewModel.email = binding.getEmail.text.toString()
//        viewModel.password = binding.getPassword.text.toString()
        toast("Started")
    }

    override fun onSuccess(firstName: UserDetail?) {
        if (firstName != null) {
            firstName.firstName?.let { toast(it) }
        }
    }

//    override fun onSuccess(firstName: UserDetail?) {
//        firstName.observe(this, Observer {
//            toast("Success : $it")
//        })
//    }

    override fun onFailed(message: String) {
        toast(message)
    }

    override fun showMessage(message: String) {
        toast(message)
    }
}