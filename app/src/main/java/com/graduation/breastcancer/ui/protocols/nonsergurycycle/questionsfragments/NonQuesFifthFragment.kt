package com.graduation.breastcancer.ui.protocols.nonsergurycycle.questionsfragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentNonQuesFifthBinding
import com.graduation.breastcancer.ui.protocols.nonsergurycycle.SubmitedSuccActivity


class NonQuesFifthFragment : Fragment() {
    private lateinit var viewBinding: FragmentNonQuesFifthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentNonQuesFifthBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setFirstQuestion()
        setSecondQuestion()
        setNav()
    }

    private fun setFirstQuestion() {
        viewBinding.q1.setOnClickListener {
            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q1.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))


        }
        viewBinding.q2.setOnClickListener {
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))


        }

        viewBinding.q3.setOnClickListener {
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))



            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))


        }


    }

    private fun setSecondQuestion() {
        viewBinding.q2a1.setOnClickListener {
            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a1.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a4.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q2a2.setOnClickListener {
            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.LightText))

            viewBinding.q2a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a4.setTextColor(resources.getColor(R.color.LightText))
        }

        viewBinding.q2a3.setOnClickListener {
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a4.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q2a4.setOnClickListener {
            viewBinding.q2a4.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a4.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.LightText))

        }
    }


    private fun setNav() {
        viewBinding.nextBtn.setOnClickListener {
            val intent = Intent(requireActivity(), SubmitedSuccActivity::class.java)
            startActivity(intent)
            requireActivity().finish()

        }

    }

}