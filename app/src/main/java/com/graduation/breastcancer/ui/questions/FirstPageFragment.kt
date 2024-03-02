package com.graduation.breastcancer.ui.questions

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentFirstPageFragmentBinding

class FirstPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentFirstPageFragmentBinding
    private lateinit var viewModel: FirstFragmentViewModel
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FirstFragmentViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFirstPageFragmentBinding.inflate(inflater, container, false)
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
            viewBinding.userLayoauat.isEnabled = false
            viewBinding.userNameInpuata.text?.clear()
            viewModel.getRegionAddressAnswer(false)
        }
        viewBinding.materialaButton1.setOnClickListener {
            viewBinding.materialaButton1.strokeWidth = 5
            viewBinding.materialaButton.strokeWidth = 0
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
            val json = gson.toJson(it)
            requireActivity().getSharedPreferences("FirstData", Context.MODE_PRIVATE)
            val pref = requireActivity().getSharedPreferences("FirstData", Context.MODE_PRIVATE)
            val edit = pref.edit().putString("FirstData", json)
            edit.apply()
            Log.e("firstData", json.toString())
        }
        viewModel.navigate.observe(viewLifecycleOwner) {
            if (it) {

                findNavController().navigate(R.id.action_firstPageFragment_to_secondPageFragment)
            }
        }


    }


}