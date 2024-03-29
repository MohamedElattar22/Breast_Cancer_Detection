package com.graduation.breastcancer.ui.questions

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.graduation.breastcancer.databinding.FragmentFourthPageBinding

class FourthPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentFourthPageBinding
    private lateinit var viewModel: FourthPageViewModel
    private val sharedViewModel by activityViewModels<ResultViewModel>()
    private val gson = Gson()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFourthPageBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FourthPageViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        observeLive()
    }

    private fun observeLive() {
        viewModel.nav.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate("fifth") {
                    anim {
                        this.enter = android.R.anim.slide_in_left
                    }
                    popUpTo(findNavController().graph.id) {
                        inclusive = false
                    }

                }

            }
        }
        viewModel.userData.observe(viewLifecycleOwner) {
            sharedViewModel.getFourthPageAnswer(it)
            val json = gson.toJson(it)
            val pref = requireActivity().getSharedPreferences("FourthData", Context.MODE_PRIVATE)
            val edit = pref.edit().putString("FourthData", json)
            edit.apply()
            Log.e("FourthData", json.toString())
        }
    }


}