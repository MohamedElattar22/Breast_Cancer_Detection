package com.graduation.breastcancer.ui.authentication.getstarted

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentGetStartedBinding
import com.graduation.breastcancer.ui.ModelActivity


class GetStartedFragment : Fragment() {
    private lateinit var viewBinding : FragmentGetStartedBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        auth = Firebase.auth
        viewBinding= FragmentGetStartedBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        WindowCompat.setDecorFitsSystemWindows(requireActivity().window , false)
        viewBinding.toRegister.setOnClickListener {
            setupNavigationToRegister()
        }
        viewBinding.toLoginTV.setOnClickListener {
            setupNavigationToLogin()
        }
    }

    override fun onStart() {
        super.onStart()
        if(auth.currentUser !=null ){
            navigateToHomeScreen()
        }
    }
    private fun navigateToHomeScreen() {
        val intent = Intent(requireActivity(), ModelActivity::class.java)
        startActivity(intent)
    }
    private fun setupNavigationToLogin() {
        findNavController().navigate(R.id.action_getStartedFragment_to_loginFragment)
    }
    private fun setupNavigationToRegister() {
        findNavController().navigate(R.id.action_getStartedFragment_to_registerFragment)
    }


}