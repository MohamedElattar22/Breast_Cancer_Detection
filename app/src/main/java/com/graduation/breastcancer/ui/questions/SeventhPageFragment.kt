package com.graduation.breastcancer.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.graduation.breastcancer.databinding.FragmentSeventhPageBinding


class SeventhPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentSeventhPageBinding
    private lateinit var viewModel: SeventhPageViewModel
    private val sharedViewModel by activityViewModels<ResultViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSeventhPageBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SeventhPageViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewBinding.lifecycleOwner = this
        viewBinding.vm = viewModel
        observeToLive()
        viewBinding.materialaButton.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 5
            viewBinding.materialaButton1.strokeWidth = 0
            viewModel.getIsThereOrangeAns(true)

        }
        viewBinding.materialaButton1.setOnClickListener {
            viewBinding.materialaButton.strokeWidth = 0
            viewBinding.materialaButton1.strokeWidth = 5
            viewModel.getIsThereOrangeAns(true)
        }

        viewBinding.male.setOnClickListener {
            viewBinding.male.strokeWidth = 5
            viewBinding.female.strokeWidth = 0
            viewModel.getIsThereRedPointsAns(true)

        }
        viewBinding.female.setOnClickListener {
            viewBinding.male.strokeWidth = 0
            viewBinding.female.strokeWidth = 5
            viewModel.getIsThereRedPointsAns(true)
        }

        viewBinding.yes12.setOnClickListener {
            viewBinding.yes12.strokeWidth = 5
            viewBinding.noo.strokeWidth = 0
            viewModel.getIsThereBloodyAns(true)

        }
        viewBinding.noo.setOnClickListener {
            viewBinding.yes12.strokeWidth = 0
            viewBinding.noo.strokeWidth = 5
            viewModel.getIsThereBloodyAns(false)
        }

        viewBinding.male12.setOnClickListener {
            viewBinding.male12.strokeWidth = 5
            viewBinding.feasmale.strokeWidth = 0
            viewModel.getIsItchyAns(true)

        }
        viewBinding.feasmale.setOnClickListener {
            viewBinding.male12.strokeWidth = 0
            viewBinding.feasmale.strokeWidth = 5
            viewModel.getIsItchyAns(false)
        }
        viewBinding.male13.setOnClickListener {
            viewBinding.male13.strokeWidth = 5
            viewBinding.feasmale1.strokeWidth = 0
            viewModel.getIsInsideAns(true)


        }
        viewBinding.feasmale1.setOnClickListener {
            viewBinding.male13.strokeWidth = 0
            viewBinding.feasmale1.strokeWidth = 5
            viewModel.getIsInsideAns(false)
        }
    }

    fun observeToLive() {
        viewModel.userData.observe(viewLifecycleOwner) {
            sharedViewModel.getSeventhPageAnswer(it)
        }
        viewModel.navigate.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate("eighth") {
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