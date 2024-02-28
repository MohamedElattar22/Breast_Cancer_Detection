package com.graduation.breastcancer.ui.authentication.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.graduation.breastcancer.databinding.FragmentSuccessCreatedBinding
import com.graduation.breastcancer.ui.questions.ActivityQuestionCycle

class SuccessCreatedFragment : Fragment() {
    private lateinit var viewBinding: FragmentSuccessCreatedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSuccessCreatedBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.toRegisterBtn.setOnClickListener {
            val nav = Intent(requireActivity(), ActivityQuestionCycle::class.java)
            startActivity(nav)
            requireActivity().finish()
        }
    }

}