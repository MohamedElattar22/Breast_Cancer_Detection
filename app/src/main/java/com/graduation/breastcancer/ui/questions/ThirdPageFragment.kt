package com.graduation.breastcancer.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.graduation.breastcancer.databinding.FragmentThirdPageBinding

class ThirdPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentThirdPageBinding
    private lateinit var viewModel: ThirdPageViewModel
    private val sharedViewModel by activityViewModels<ResultViewModel>()
    private val gson = Gson()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentThirdPageBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ThirdPageViewModel::class.java]
        initViews()
    }

    private fun initViews() {
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this

        viewBinding.materialaButton.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 5
            viewBinding.materialaButton1.strokeWidth = 0
            viewBinding.userLayouat.isVisible = true
            viewModel.getPrevRadiational(true)

        }
        viewBinding.materialaButton1.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 0
            viewBinding.materialaButton1.strokeWidth = 5
            viewBinding.userLayouat.isVisible = false
            viewModel.getPrevRadiational(false)
        }
        viewBinding.male.setOnClickListener {
            viewBinding.male.strokeWidth = 5
            viewBinding.female.strokeWidth = 0
            viewModel.getPrevTreatAnswer(true)
        }
        viewBinding.female.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 5
            viewModel.getPrevTreatAnswer(false)
        }

        viewBinding.yes12.setOnClickListener {
            viewBinding.yes12.strokeWidth = 5
            viewBinding.noo.strokeWidth = 0
            viewBinding.userLayouatas.isVisible = true
            viewModel.getBirthControlAnswer(true)

        }
        viewBinding.noo.setOnClickListener {
            viewBinding.yes12.strokeWidth = 0
            viewBinding.noo.strokeWidth = 5
            viewBinding.userLayouatas.isVisible = false
            viewModel.getBirthControlAnswer(false)
        }

        viewBinding.male12.setOnClickListener {
            viewBinding.male12.strokeWidth = 5
            viewBinding.feasmale.strokeWidth = 0
            viewModel.getOtherHarmoneyAnswer(true)

        }
        viewBinding.feasmale.setOnClickListener {
            viewBinding.male12.strokeWidth = 0
            viewBinding.feasmale.strokeWidth = 5
            viewModel.getOtherHarmoneyAnswer(false)
        }


        viewBinding.userLayouat.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val textView = view as TextView
                    val text = textView.text.toString()
                    viewModel.getBreastTreatmentType(text)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
        observe()
    }

    private fun observe() {
        viewModel.navigate.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate("fourth") {
                    anim {
                        this.enter = android.R.anim.slide_in_left
                    }
                    popUpTo(findNavController().graph.id) {
                        inclusive = false
                    }

                }

            }
        }
        viewModel.prevTreatTypeError.observe(viewLifecycleOwner) {
            it?.let {
                val text = viewBinding.userLayouat.selectedView as TextView
                text.error = it
            }
        }
        viewModel.userData.observe(viewLifecycleOwner) {
            sharedViewModel.getThirdPageAnswer(it)
//            val json = gson.toJson(it)
//            val pref = requireActivity().getSharedPreferences("ThirdData", Context.MODE_PRIVATE)
//            val edit = pref.edit().putString("ThirdData", json)
//            edit.apply()
//            Log.e("ThirdData", json.toString())
        }
    }


}