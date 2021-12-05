package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * Fragment to sign/register user into shoe store
 */
class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        binding.controller = this
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        (activity as MainActivity).supportActionBar?.title =  getString(R.string.login_title_actionbar)
        return binding.root
    }

    fun register() {
        if (loginViewModel.register(binding.loginEdittext.text.toString(), binding.passwordEdittext.text.toString())) {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        } else {
            showRegisterError()
        }
    }

    fun login() {
        if (loginViewModel.login(binding.loginEdittext.text.toString(), binding.passwordEdittext.text.toString())) {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        } else {
            showRegisterError()
        }
    }
    /**
     * Show login error, right now this will not be called because no check against database implemented
     */
    private fun showLoginError() {
        binding.loginEdittext.error = getString(R.string.login_error)
    }
    /**
     * Show register error the rules are implemented in viewmodel class
     */
    private fun showRegisterError() {
        binding.loginEdittext.error = getString(R.string.register_error)
    }

}