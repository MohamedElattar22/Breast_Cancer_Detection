package com.graduation.breastcancer.ui.questions

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.graduation.breastcancer.databinding.FragmentFirstPageFragmentBinding


class FirstPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentFirstPageFragmentBinding
    private lateinit var viewModel: FirstFragmentViewModel
    private val sharedViewModel by activityViewModels<ResultViewModel>()

    private val gson = Gson()
    val callback: OnBackPressedCallback =
        object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FirstFragmentViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFirstPageFragmentBinding.inflate(inflater, container, false)
//        callback.handleOnBackPressed()
        viewBinding.vm= viewModel
        viewBinding.lifecycleOwner = this
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeLiveData()
    }

    @SuppressLint("ResourceAsColor")
    private fun initViews() {

        viewBinding.male.setOnClickListener {
            viewBinding.male.strokeWidth = 5
            viewBinding.female.strokeWidth = 0
            viewModel.getGender("male")
        }
        viewBinding.female.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 5
            viewModel.getGender("female")
        }
        viewBinding.spinner.onItemSelectedListener = object :OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               if (position==0)
               {
                   viewModel.getMaritalStatus("")
                   return
               }
                val textView = view as TextView
                val text = textView.text.toString()
                viewModel.getMaritalStatus(text)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        viewBinding.materialaButton.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 5
            viewBinding.materialaButton1.strokeWidth = 0
            viewBinding.userLayoauat.isVisible = false
            viewBinding.userLayoauat.isEnabled = false
            viewBinding.userNameInpuata.text?.clear()
            viewModel.getRegionAddressAnswer(false)
        }
        viewBinding.materialaButton1.setOnClickListener {
            viewBinding.materialaButton1.strokeWidth = 5
            viewBinding.materialaButton.strokeWidth = 0
            viewBinding.userLayoauat.isVisible = true
            viewBinding.userLayoauat.isEnabled = true
            viewModel.getRegionAddressAnswer(true)
        }
    }

    private fun observeLiveData() {
        viewModel.maritalStatusError.observe(viewLifecycleOwner) {
            it?.let {
                val text = viewBinding.spinner.selectedView as TextView
                text.error = it
            }
        }
        viewModel.userData.observe(viewLifecycleOwner) {
            sharedViewModel.getFirstPageAnswer(it)
        }
        viewModel.navigate.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate("second") {
                    anim {
                        this.enter = android.R.anim.slide_in_left
                    }
                    popUpTo(findNavController().graph.id) {
                        inclusive = false
                    }

                }


            }
        }


    }


}