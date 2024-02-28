package com.graduation.breastcancer.ui.authentication.login

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentLoginBinding
import com.graduation.breastcancer.ui.questions.ActivityQuestionCycle
import com.graduation.breastcancer.utils.RegexConstants


class LoginFragment : Fragment() {
    private lateinit var viewBinding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var dialog: Dialog
    private lateinit var auth: FirebaseAuth
    private var txtWatcher: TextWatcher? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        auth = Firebase.auth
        viewBinding = FragmentLoginBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
    private fun setupDialog(){
        dialog = Dialog(requireActivity())
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        val dialogView = LayoutInflater.from(requireActivity()).inflate(R.layout.loading_dialog, null)
        dialog.setContentView(dialogView)
    }
    private fun initViews() {
        textChanger()
        setupDialog()
        viewBinding.dontHaveAccTV.setOnClickListener {
            navigateToRegister()
        }
        viewBinding.loginBtn.setOnClickListener {
            loginUser()
            dialog.show()
        }
        subscribeToLiveData()
    }
    private fun loginUser() {
        val email = viewBinding.emailInput.text.toString()
        val password = viewBinding.passwordInput.text.toString()
        viewModel.loginUser(email, password)

        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {

        viewModel.navigate.observe(viewLifecycleOwner){
            if(it){
                navigateToHomeScreen()
                val user = auth.currentUser
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
        viewModel.error.observe(viewLifecycleOwner){
            if(it){
                Snackbar.make(
                    viewBinding.root,
                    "Some Thing wen wrong",
                    Snackbar.LENGTH_SHORT
                ).show()
                dialog.dismiss()
            }
        }
        viewModel.errorMessage.observe(viewLifecycleOwner){
            Snackbar.make(
                viewBinding.root,
                it,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun navigateToHomeScreen() {
        val intent = Intent(requireActivity(), ActivityQuestionCycle::class.java)
        startActivity(intent)
    }

    private fun navigateToRegister(){
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }
    private fun validateEmail(email: String): Boolean {
        return RegexConstants.emailPattern.matches(email)
    }
    private fun textChanger() {

        txtWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val email = viewBinding.emailInput.text.toString()
                val password = viewBinding.passwordInput.text.toString()

                if (email.isBlank() || !validateEmail(email)
                ) {
                    viewBinding.loginBtn.isEnabled = false
                    viewBinding.emailLayout.error = "Enter a valid email"

                } else {
                    viewBinding.emailLayout.error = ""
                    viewBinding.loginBtn.isEnabled = true

                }
                if(password.isBlank()){
                    viewBinding.loginBtn.isEnabled = false
                    viewBinding.passwordLayout.error = "Enter a valid password"
                }
                else{
                    viewBinding.passwordLayout.error = ""
                    viewBinding.loginBtn.isEnabled = true
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        }
        viewBinding.emailInput.addTextChangedListener(txtWatcher)
        viewBinding.passwordInput.addTextChangedListener(txtWatcher)
    }

}