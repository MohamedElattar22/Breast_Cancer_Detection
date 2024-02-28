package com.graduation.breastcancer.ui.questions

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentSecondPageBinding

class SecondPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentSecondPageBinding
    private lateinit var viewModel: SecondPageViewModel
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

        viewModel = ViewModelProvider(requireActivity())[SecondPageViewModel::class.java]
    }

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
            viewModel.getGender(R.string.male.toString())
        }
        viewBinding.female.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 5
            viewBinding.bothBtn.strokeWidth = 0
            viewModel.getGender(R.string.female.toString())
        }
        viewBinding.bothBtn.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 0
            viewBinding.bothBtn.strokeWidth = 5
            viewModel.getGender(R.string.both.toString())
        }
        viewBinding.yesHasBtn.setOnClickListener {
            viewBinding.yesHasBtn.strokeWidth = 5
            viewBinding.noDontBtn.strokeWidth = 0
            viewModel.getRelativesHasCancer(true)
            viewBinding.male.isEnabled = true
            viewBinding.female.isEnabled = true
            viewBinding.bothBtn.isEnabled = true
            viewBinding.ageInput.isEnabled = true
            viewBinding.relativesSpinner.isEnabled = true
            viewBinding.othersInput.isEnabled = true
            viewBinding.ageOfDia.isEnabled = true
            viewBinding.othersInput.isEnabled = true
        }
        viewBinding.noDontBtn.setOnClickListener {
            viewBinding.yesHasBtn.strokeWidth = 0
            viewBinding.noDontBtn.strokeWidth = 5
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 0
            viewBinding.bothBtn.strokeWidth = 0
            viewModel.getRelativesHasCancer(false)
            viewBinding.male.isEnabled = false
            viewBinding.female.isEnabled = false
            viewBinding.bothBtn.isEnabled = false
            viewBinding.ageInput.isEnabled = false
            viewBinding.ageInput.text?.clear()
            viewBinding.relativesSpinner.isEnabled = false
            viewBinding.othersInput.isEnabled = false
            viewBinding.othersInput.isEnabled = false
            viewBinding.ageInput.text?.clear()
            viewBinding.ageOfDia.isEnabled = false
            viewBinding.ageOfDia.text?.clear()
            viewBinding.othersInput.isEnabled = false
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
            val json = gson.toJson(it)
            val pref = requireActivity().getSharedPreferences("SecondData", Context.MODE_PRIVATE)
            val edit = pref.edit().putString("SecondData", json)
            edit.apply()
            Log.e("SecondData", json.toString())
        }
        viewModel.navigate.observe(viewLifecycleOwner) {
            if (it) {
                Log.e("nav", it.toString())
                findNavController().navigate(R.id.action_secondPageFragment_to_thirdPageFragment)
            }

        }
    }


}