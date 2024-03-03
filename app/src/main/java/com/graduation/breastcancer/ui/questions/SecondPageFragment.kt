package com.graduation.breastcancer.ui.questions

import android.os.Bundle
import android.util.Log
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
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentSecondPageBinding

class SecondPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentSecondPageBinding
    private lateinit var viewModel: SecondPageViewModel
    private val sharedViewModel by activityViewModels<ResultViewModel>()
    private val gson = Gson()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSecondPageBinding.inflate(inflater, container, false)
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
//            findNavController().popBackStack()
//        }
//        callback.handleOnBackPressed()
        viewModel = ViewModelProvider(requireActivity())[SecondPageViewModel::class.java]
    }
//    val callback: OnBackPressedCallback =
//        object : OnBackPressedCallback(true /* enabled by default */) {
//            override fun handleOnBackPressed() {
//                findNavController().navigate(R.id.action_secondPageFragment_to_firstPageFragment)
//            }
//        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeLive()
    }


    private fun initViews() {
        viewBinding.male.setOnClickListener {
            viewBinding.male.strokeWidth = 5
            viewBinding.female.strokeWidth = 0
            viewBinding.bothBtn.strokeWidth = 0
            viewModel.getGender(getString(R.string.male))
        }
        viewBinding.female.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 5
            viewBinding.bothBtn.strokeWidth = 0
            viewModel.getGender(getString(R.string.female))
        }
        viewBinding.bothBtn.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 0
            viewBinding.bothBtn.strokeWidth = 5
            viewModel.getGender(getString(R.string.both))
        }
        viewBinding.yesHasBtn.setOnClickListener {
            viewBinding.yesHasBtn.strokeWidth = 5
            viewBinding.noDontBtn.strokeWidth = 0
            viewModel.getRelativesHasCancer(true)
            viewBinding.male.isVisible = true
            viewBinding.female.isVisible = true
            viewBinding.bothBtn.isVisible = true
            viewBinding.ageInput.isVisible = true
            viewBinding.AgeOfDiagnosisTV.isVisible = true
            viewBinding.textView14.isVisible = true
            viewBinding.otherDiagnosisTV.isVisible = true
            viewBinding.relativesSpinner.isVisible = true
            viewBinding.othersInput.isVisible = true
            viewBinding.ageOfDia.isVisible = true
            viewBinding.othersInput.isVisible = true
        }
        viewBinding.noDontBtn.setOnClickListener {
            viewBinding.yesHasBtn.strokeWidth = 0
            viewBinding.noDontBtn.strokeWidth = 5
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 0
            viewBinding.bothBtn.strokeWidth = 0
            viewModel.getRelativesHasCancer(false)
            viewBinding.male.isVisible = false
            viewBinding.female.isVisible = false
            viewBinding.bothBtn.isVisible = false
            viewBinding.otherDiagnosisTV.isVisible = false
            viewBinding.ageInput.isVisible = false
            viewBinding.ageInput.text?.clear()
            viewBinding.textView14.isVisible = false
            viewBinding.relativesSpinner.isVisible = false
            viewBinding.othersInput.isVisible = false
            viewBinding.othersInput.isVisible = false
            viewBinding.ageInput.text?.clear()
            viewBinding.AgeOfDiagnosisTV.isVisible = false
            viewBinding.ageOfDia.isVisible = false
            viewBinding.ageOfDia.text?.clear()
            viewBinding.othersInput.isVisible = false
            viewBinding.othersInput.text?.clear()


        }
        viewBinding.relativesSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (position == 0) {
                        viewModel.getRelationalDegree("")
                        return
                    }
                    val textView = view as TextView
                    val text = textView.text.toString()
                    viewModel.getRelationalDegree(text)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }

    }

    fun observeLive() {
        viewModel.relationalDegreeError.observe(viewLifecycleOwner) {
            it?.let {
                val text = viewBinding.relativesSpinner.selectedView as TextView
                text.error = it
            }
        }
        viewModel.userData.observe(viewLifecycleOwner) {
            sharedViewModel.getSecondPageAnswer(it)
//            val json = gson.toJson(it)
//            val pref = requireActivity().getSharedPreferences("userData", Context.MODE_PRIVATE)
//            val fData = pref.getString("first" , null)
//
//            val edit = pref.edit().putString("SecondData", json + fData)
//            edit.apply()
//            val res = pref.getString("SecondData","")
//            Log.e("SecondData", res!!)
        }
        viewModel.navigate.observe(viewLifecycleOwner) {
            if (it) {
                Log.e("nav", it.toString())
                findNavController().navigate("third") {
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