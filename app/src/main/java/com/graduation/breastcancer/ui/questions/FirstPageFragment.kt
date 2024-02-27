package com.graduation.breastcancer.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.graduation.breastcancer.databinding.FragmentFirstPageFragmentBinding

class FirstPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentFirstPageFragmentBinding
    var clicked = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFirstPageFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()
//        bundle.putParcelable("FirstPageData",)
        initViews()
    }

    private fun initViews() {
        viewBinding.nextBtn.setOnClickListener {
            val action = FirstPageFragmentDirections.actionFirstPageFragmentToSecondPageFragment()
            findNavController().navigate(action)

        }

        viewBinding.male.setOnClickListener {
            viewBinding.male.strokeWidth = 5
            viewBinding.female.strokeWidth = 0

        }
        viewBinding.female.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 5

        }
    }


}