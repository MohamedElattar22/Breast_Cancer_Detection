package com.graduation.breastcancer.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.graduation.breastcancer.databinding.FragmentFifthPageBinding

class FifthPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentFifthPageBinding
    private lateinit var viewModel: FifthPageViewModel
    private val sharedViewModel by activityViewModels<ResultViewModel>()
    private val gson = Gson()
    val list = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFifthPageBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FifthPageViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun observe() {
        viewModel.userData.observe(viewLifecycleOwner) { task ->

//            Log.e("FifthData", json.toString())
            sharedViewModel.getFifthPageAnswer(task)
//            val result = sharedViewModel.fillDataOfUser()
//            Log.d("totalData", result.toString())
//            val json = gson.toJson(result)
//            val pref = requireActivity().getSharedPreferences("User", Context.MODE_PRIVATE)
//            if (!pref.contains("ReportQuestions")) {
//                val list = mutableSetOf(json)
//                val edit = pref.edit().putStringSet("ReportQuestions", list)
//                edit.apply()
//            } else {
//                pref.getStringSet("ReportQuestions", mutableSetOf())?.let {
//                    val res = it.toMutableList()
//                    list.addAll(res)
//                    list.add(json)
//                }
//                pref.edit().putStringSet("ReportQuestions", list.toMutableSet()).apply()
//            }
//
//            Log.d("list res", list.toString())
        }
        viewModel.nav.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate("sixth") {
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


    private fun initViews() {
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        observe()
        viewBinding.materialaButton.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 5
            viewBinding.materialaButton1.strokeWidth = 0
            viewModel.getBreadfNaturalAns(true)
        }
        viewBinding.materialaButton1.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 0
            viewBinding.materialaButton1.strokeWidth = 5
            viewModel.getBreadfNaturalAns(false)
        }
        viewBinding.male.setOnClickListener {
            viewBinding.male.strokeWidth = 5
            viewBinding.female.strokeWidth = 0
            viewModel.getRegExerciseAns(true)
        }
        viewBinding.female.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 5
            viewModel.getRegExerciseAns(false)
        }
        viewBinding.yes12.setOnClickListener {
            viewBinding.yes12.strokeWidth = 5
            viewBinding.noo.strokeWidth = 0
            viewModel.getExecWeightAns(true)
        }
        viewBinding.noo.setOnClickListener {
            viewBinding.yes12.strokeWidth = 0
            viewBinding.noo.strokeWidth = 5
            viewModel.getExecWeightAns(false)
        }
        viewBinding.userLayouat.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (position == 0) {
                        viewModel.getRace("")
                        return
                    }
                    val textView = view as TextView
                    val text = textView.text.toString()
                    viewModel.getRace(text)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }

        viewBinding.yes1a2.setOnClickListener {
            viewBinding.yes1a2.strokeWidth = 5
            viewBinding.noso.strokeWidth = 0
            viewModel.getIsSmokerAns(true)
        }
        viewBinding.noso.setOnClickListener {
            viewBinding.yes1a2.strokeWidth = 0
            viewBinding.noso.strokeWidth = 5
            viewModel.getIsSmokerAns(false)
        }
        viewBinding.yea2.setOnClickListener {
            viewBinding.yea2.strokeWidth = 5
            viewBinding.naao.strokeWidth = 0
            viewModel.getIsFamilyMemberSmokeAns(true)
        }
        viewBinding.naao.setOnClickListener {
            viewBinding.yea2.strokeWidth = 0
            viewBinding.naao.strokeWidth = 5
            viewModel.getIsFamilyMemberSmokeAns(false)
        }
        viewBinding.yeaas2.setOnClickListener {
            viewBinding.yeaas2.strokeWidth = 5
            viewBinding.nasaso.strokeWidth = 0
            viewModel.getAlcoholAns(true)
        }
        viewBinding.nasaso.setOnClickListener {
            viewBinding.yeaas2.strokeWidth = 0
            viewBinding.nasaso.strokeWidth = 5
            viewModel.getAlcoholAns(false)
        }


    }


}