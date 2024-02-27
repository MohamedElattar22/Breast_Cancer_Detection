package com.graduation.breastcancer.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentThirdPageBinding

class ThirdPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentThirdPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentThirdPageBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewBinding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_thirdPageFragment_to_fourthPageFragment)
        }
    }


}