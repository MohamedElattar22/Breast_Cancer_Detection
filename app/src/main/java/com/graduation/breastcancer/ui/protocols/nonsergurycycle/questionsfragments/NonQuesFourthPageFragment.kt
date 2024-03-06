package com.graduation.breastcancer.ui.protocols.nonsergurycycle.questionsfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentNonQuesFourthPageBinding


class NonQuesFourthPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentNonQuesFourthPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentNonQuesFourthPageBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setFirstQuestion()
        setSecondQuestion()
        setThirdQuestion()
        setFourthQuestion()
        setNav()
    }

    private fun setFirstQuestion() {
        viewBinding.q1.setOnClickListener {
            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q1.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4.setTextColor(resources.getColor(R.color.LightText))


        }
        viewBinding.q2.setOnClickListener {
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4.setTextColor(resources.getColor(R.color.LightText))

        }

        viewBinding.q3.setOnClickListener {
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4.setTextColor(resources.getColor(R.color.LightText))


        }
        viewBinding.q4.setOnClickListener {
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))

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

        }
        viewBinding.q2a2.setOnClickListener {
            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.LightText))


        }

        viewBinding.q2a3.setOnClickListener {
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a2.setTextColor(resources.getColor(R.color.LightText))

        }
    }

    private fun setThirdQuestion() {
        viewBinding.q3a1.setOnClickListener {
            viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3a1.setTextColor(resources.getColor(R.color.white))

            viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q3a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a3.setTextColor(resources.getColor(R.color.LightText))


        }
        viewBinding.q3a2.setOnClickListener {
            viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3a2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q3a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a3.setTextColor(resources.getColor(R.color.LightText))


        }

        viewBinding.q3a3.setOnClickListener {
            viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3a3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q3a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a2.setTextColor(resources.getColor(R.color.LightText))


        }

    }

    private fun setFourthQuestion() {
        viewBinding.q4a1.setOnClickListener {
            viewBinding.q4a1.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4a1.setTextColor(resources.getColor(R.color.white))

            viewBinding.q4a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a3.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q4a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a3.setTextColor(resources.getColor(R.color.LightText))


        }
        viewBinding.q4a2.setOnClickListener {
            viewBinding.q4a2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4a2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a3.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q4a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a3.setTextColor(resources.getColor(R.color.LightText))


        }

        viewBinding.q4a3.setOnClickListener {
            viewBinding.q4a3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4a3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a2.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q4a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a2.setTextColor(resources.getColor(R.color.LightText))


        }

    }

    private fun setNav() {
        viewBinding.nextBtn.setOnClickListener {
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

}