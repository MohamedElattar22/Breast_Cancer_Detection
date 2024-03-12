package com.graduation.breastcancer.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.graduation.breastcancer.databinding.FragmentSixthPageBinding


class SixthPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentSixthPageBinding
    private lateinit var viewModel: SixthPageViewModel
    private val sharedViewModel by activityViewModels<ResultViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SixthPageViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSixthPageBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        observeLiveData()

        viewBinding.materialaButton.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 5
            viewBinding.materialaButton1.strokeWidth = 0
            viewModel.getStrangePiecesAns(true)

        }
        viewBinding.materialaButton1.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 0
            viewBinding.materialaButton1.strokeWidth = 5
            viewModel.getStrangePiecesAns(false)
        }

        viewBinding.male.setOnClickListener {
            viewBinding.male.strokeWidth = 5
            viewBinding.female.strokeWidth = 0
            viewModel.getIsPiecesHardAns(true)

        }
        viewBinding.female.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 5
            viewModel.getIsPiecesHardAns(false)
        }

        viewBinding.yes12.setOnClickListener {
            viewBinding.yes12.strokeWidth = 5
            viewBinding.noo.strokeWidth = 0
            viewModel.getIsPiecesSlowlyGrowAns(true)

        }
        viewBinding.noo.setOnClickListener {
            viewBinding.yes12.strokeWidth = 0
            viewBinding.noo.strokeWidth = 5
            viewModel.getIsPiecesSlowlyGrowAns(false)
        }

        viewBinding.male12.setOnClickListener {
            viewBinding.male12.strokeWidth = 5
            viewBinding.feasmale.strokeWidth = 0
            viewModel.getIsPiecesMeandersAns(true)

        }
        viewBinding.feasmale.setOnClickListener {
            viewBinding.male12.strokeWidth = 0
            viewBinding.feasmale.strokeWidth = 5
            viewModel.getIsPiecesMeandersAns(false)
        }
        viewBinding.male13.setOnClickListener {
            viewBinding.male13.strokeWidth = 5
            viewBinding.feasmale1.strokeWidth = 0
            viewModel.getIsPiecesPainfulAns(true)


        }
        viewBinding.feasmale1.setOnClickListener {
            viewBinding.male13.strokeWidth = 0
            viewBinding.feasmale1.strokeWidth = 5
            viewModel.getIsPiecesPainfulAns(false)
        }

    }

    private fun observeLiveData() {
        viewModel.userData.observe(viewLifecycleOwner) {
            sharedViewModel.getSixthPageAnswer(it)
        }
        viewModel.navigate.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate("seventh") {
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