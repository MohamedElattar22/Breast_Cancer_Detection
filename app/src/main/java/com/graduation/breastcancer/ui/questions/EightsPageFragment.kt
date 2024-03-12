package com.graduation.breastcancer.ui.questions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.graduation.breastcancer.databinding.FragmentEightsPageBinding
import com.graduation.breastcancer.ui.mlmodel.ModelActivity

class EightsPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentEightsPageBinding
    private lateinit var viewModel: EighthPageViewModel
    private val sharedViewModel by activityViewModels<ResultViewModel>()
    private val gson = Gson()
    val list = mutableListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEightsPageBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[EighthPageViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewBinding.lifecycleOwner = this
        viewBinding.vm = viewModel
        observeToLiveData()
        viewBinding.materialaButton.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 5
            viewBinding.materialaButton1.strokeWidth = 0
            viewModel.getIsExcretedAns(true)

        }
        viewBinding.materialaButton1.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 0
            viewBinding.materialaButton1.strokeWidth = 5
            viewModel.getIsExcretedAns(false)
        }

        viewBinding.male.setOnClickListener {
            viewBinding.male.strokeWidth = 5
            viewBinding.female.strokeWidth = 0
            viewModel.getIsClothesDirtAns(true)

        }
        viewBinding.female.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 5
            viewModel.getIsClothesDirtAns(false)
        }

        viewBinding.yes12.setOnClickListener {
            viewBinding.yes12.strokeWidth = 5
            viewBinding.noo.strokeWidth = 0
            viewModel.getIsContentiousAns(true)

        }
        viewBinding.noo.setOnClickListener {
            viewBinding.yes12.strokeWidth = 0
            viewBinding.noo.strokeWidth = 5
            viewModel.getIsContentiousAns(false)
        }

        viewBinding.male12.setOnClickListener {
            viewBinding.male12.strokeWidth = 5
            viewBinding.feasmale.strokeWidth = 0
            viewModel.getIsExcretedBloodyAns(true)

        }
        viewBinding.feasmale.setOnClickListener {
            viewBinding.male12.strokeWidth = 0
            viewBinding.feasmale.strokeWidth = 5
            viewModel.getIsExcretedBloodyAns(false)
        }
        viewBinding.male13.setOnClickListener {
            viewBinding.male13.strokeWidth = 5
            viewBinding.feasmale1.strokeWidth = 0
            viewModel.getNto2Ans(true)


        }
        viewBinding.feasmale1.setOnClickListener {
            viewBinding.male13.strokeWidth = 0
            viewBinding.feasmale1.strokeWidth = 5
            viewModel.getNto2Ans(false)
        }
        viewBinding.male14.setOnClickListener {
            viewBinding.male14.strokeWidth = 5
            viewBinding.feasmale2.strokeWidth = 0
            viewModel.getIsNonPregnantAns(true)
        }
        viewBinding.feasmale2.setOnClickListener {
            viewBinding.male14.strokeWidth = 0
            viewBinding.feasmale2.strokeWidth = 5
            viewModel.getIsNonPregnantAns(false)
        }
        viewBinding.male15.setOnClickListener {
            viewBinding.male15.strokeWidth = 5
            viewBinding.feasmale3.strokeWidth = 0
            viewModel.getIsPainfulAns(true)
        }
        viewBinding.feasmale3.setOnClickListener {
            viewBinding.male15.strokeWidth = 0
            viewBinding.feasmale3.strokeWidth = 5
            viewModel.getIsPainfulAns(false)
        }
    }

    private fun observeToLiveData() {
        viewModel.userData.observe(viewLifecycleOwner) { task ->
            sharedViewModel.getEighthPageAnswer(task)
            val result = sharedViewModel.fillDataOfUser()
            Log.d("totalData", result.toString())
            val json = gson.toJson(result)
            val pref = requireActivity().getSharedPreferences("User", Context.MODE_PRIVATE)
            if (!pref.contains("ReportQuestions")) {
                val list = mutableSetOf(json)
                val edit = pref.edit().putStringSet("ReportQuestions", list)
                edit.apply()
            } else {
                pref.getStringSet("ReportQuestions", mutableSetOf())?.let {
                    val res = it.toMutableList()
                    list.addAll(res)
                    list.add(json)
                }
                pref.edit().putStringSet("ReportQuestions", list.toMutableSet()).apply()
            }

            Log.d("list res", list.toString())
        }
        viewModel.navigate.observe(viewLifecycleOwner) {
            if (it) {
                navigateToModelActivity()
            }
        }
    }

    private fun navigateToModelActivity() {
        val intent = Intent(requireActivity(), ModelActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }


}