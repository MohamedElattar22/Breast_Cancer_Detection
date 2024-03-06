package com.graduation.breastcancer.ui.authentication.signup

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentRegisterBinding
import com.graduation.breastcancer.utils.RegexConstants


class RegisterFragment : Fragment() {
    private lateinit var viewBinding : FragmentRegisterBinding
    private lateinit var viewModel : SignUpViewModel
    private var txtWatcher: TextWatcher? = null
    private lateinit var dialog: Dialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentRegisterBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SignUpViewModel::class.java]
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        textChanger()
        setupDialog()
        viewBinding.dontHaveAccTV.setOnClickListener {
            navigateToLogin()
        }
        viewBinding.loginBtn.setOnClickListener {
            registerUser()
            dialog.show()
        }
        subscribeToLiveData()
    }
    private fun subscribeToLiveData(){

        viewModel.data.observe(viewLifecycleOwner){
            Snackbar.make(
                viewBinding.root,
                it,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        viewModel.navigate.observe(viewLifecycleOwner){
            if(it){
                navigateToSuccess()
                dialog.dismiss()
            }
            else{
                Snackbar.make(
                    viewBinding.root,
                    "Some Thing wen wrong",
                    Snackbar.LENGTH_SHORT
                ).show()
                dialog.dismiss()
            }
        }
    }

    private fun navigateToSuccess() {
        findNavController().navigate(R.id.action_registerFragment_to_successCreatedFragment)
    }

    private fun registerUser(){
        val email = viewBinding.emailInput.text.toString()
        val pass = viewBinding.passwordInput.text.toString()
        Log.e("mail", email )
        Log.e("pass", pass )
        viewModel.registerUser(email, pass)

    }

    private fun setupDialog(){
        dialog = Dialog(requireActivity())
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        val dialogView = LayoutInflater.from(requireActivity()).inflate(R.layout.loading_dialog, null)
        dialog.setContentView(dialogView)
    }

    private fun navigateToLogin(){
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }
    private fun textChanger() {

        txtWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val userName = viewBinding.userNameInput.text.toString()
                val email = viewBinding.emailInput.text.toString()
                val password = viewBinding.passwordInput.text.toString()
                val passwordConf=viewBinding.passwordConfInput.text.toString()
                if(userName.isBlank()){
                    viewBinding.loginBtn.isEnabled = false
                    viewBinding.userLayout.error = "User name mustn't be empty"
                }else{
                    viewBinding.userLayout.error = ""
                    viewBinding.loginBtn.isEnabled = true
                }
                if (email.isBlank() || !validateEmail(email)
                ) {
                    viewBinding.loginBtn.isEnabled = false
                    viewBinding.emailContainer.error = "Enter a valid email"

                } else {
                    viewBinding.emailContainer.error = ""
                    viewBinding.loginBtn.isEnabled = true

                }

                if(password.isBlank()){
                    viewBinding.loginBtn.isEnabled = false
                    viewBinding.passwordContainer.error = "Enter a valid password"
                }
                else{
                    viewBinding.passwordContainer.error = ""
                    viewBinding.loginBtn.isEnabled = true
                }
                if(passwordConf.isBlank()){
                    viewBinding.loginBtn.isEnabled = false
                    viewBinding.passwordConfContainer.error = "Enter a valid password"
                }
                else{
                    viewBinding.loginBtn.isEnabled = true
                    viewBinding.passwordConfContainer.error = ""
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }

        }
        viewBinding.userNameInput.addTextChangedListener(txtWatcher)
        viewBinding.emailInput.addTextChangedListener(txtWatcher)
        viewBinding.passwordInput.addTextChangedListener(txtWatcher)
        viewBinding.passwordConfInput.addTextChangedListener(txtWatcher)
    }
    private fun validateEmail(email: String): Boolean {
        return RegexConstants.emailPattern.matches(email)
    }

}