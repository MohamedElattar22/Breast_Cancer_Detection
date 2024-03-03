package com.graduation.breastcancer.ui.protocols.nonsergurycycle.questionsfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentNonQuesFirstPageBinding


class NonQuesFirstPageFragment : Fragment() {
    private lateinit var viewBinding: FragmentNonQuesFirstPageBinding
    var temp1 = 1
    var temp2 = 1
    var temp3 = 1
    var temp4 = 1
    var temp5 = 1
    var temp6 = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentNonQuesFirstPageBinding.inflate(inflater, container, false)
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
        viewBinding.yesForOpBtn.setOnClickListener {
            viewBinding.yesForOpBtn.strokeWidth = 5
            viewBinding.noBtn.strokeWidth = 0
        }
        viewBinding.noBtn.setOnClickListener {
            viewBinding.yesForOpBtn.strokeWidth = 0
            viewBinding.noBtn.strokeWidth = 5
        }
    }


    private fun setSecondQuestion() {

        viewBinding.q1.setOnClickListener {

            if (temp1 == 1) {
                viewBinding.q1.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q1.setTextColor(resources.getColor(R.color.white))
                Log.d("temp", temp1.toString())
                temp1 = 0
            } else if (temp1 == 0) {
                viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
                temp1 = 1
                Log.d("temp", temp1.toString())
            }

        }

        viewBinding.q2.setOnClickListener {


            if (temp2 == 1) {
                viewBinding.q2.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q2.setTextColor(resources.getColor(R.color.white))
                temp2 = 0
            } else if (temp2 == 0) {
                viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
                temp2 = 1

            }


        }

        viewBinding.q3.setOnClickListener {

            if (temp3 == 1) {
                viewBinding.q3.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q3.setTextColor(resources.getColor(R.color.white))
                temp3 = 0
            } else if (temp3 == 0) {
                viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))
                temp3 = 1
            }

        }
        viewBinding.q4.setOnClickListener {

            if (temp4 == 1) {
                viewBinding.q4.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q4.setTextColor(resources.getColor(R.color.white))
                temp4 = 0
            } else if (temp4 == 0) {
                viewBinding.q4.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q4.setTextColor(resources.getColor(R.color.LightText))
                temp4 = 1

            }


        }
        viewBinding.q5.setOnClickListener {


            if (temp5 == 1) {
                viewBinding.q5.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q5.setTextColor(resources.getColor(R.color.white))

                temp5 = 0
            } else if (temp5 == 0) {
                viewBinding.q5.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q5.setTextColor(resources.getColor(R.color.LightText))
                temp5 = 1

            }


        }
        viewBinding.q6.setOnClickListener {

            if (temp6 == 1) {
                viewBinding.q6.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q6.setTextColor(resources.getColor(R.color.white))
                temp6 = 0
            } else if (temp6 == 0) {
                viewBinding.q6.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q6.setTextColor(resources.getColor(R.color.LightText))
                temp6 = 1

            }


        }
    }

    private fun setThirdQuestion() {
        viewBinding.q3a1.setOnClickListener {
            viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3a1.setTextColor(resources.getColor(R.color.white))

            viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q3a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q3a2.setOnClickListener {
            viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3a2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a6.setTextColor(resources.getColor(R.color.LightText))

        }

        viewBinding.q3a3.setOnClickListener {
            viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3a3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q3a4.setOnClickListener {
            viewBinding.q3a4.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3a4.setTextColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q3a5.setOnClickListener {
            viewBinding.q3a5.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3a5.setTextColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q3a6.setOnClickListener {
            viewBinding.q3a6.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3a6.setTextColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3a5.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q3a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3a5.setTextColor(resources.getColor(R.color.LightText))

        }
    }

    private fun setFourthQuestion() {
        viewBinding.q4a1.setOnClickListener {
            viewBinding.q4a1.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4a1.setTextColor(resources.getColor(R.color.white))

            viewBinding.q4a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q4a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q4a2.setOnClickListener {
            viewBinding.q4a2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4a2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a6.setTextColor(resources.getColor(R.color.LightText))

        }

        viewBinding.q4a3.setOnClickListener {
            viewBinding.q4a3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4a3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q4a4.setOnClickListener {
            viewBinding.q4a4.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4a4.setTextColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q4a5.setOnClickListener {
            viewBinding.q4a5.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4a5.setTextColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q4a6.setOnClickListener {
            viewBinding.q4a6.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4a6.setTextColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4a5.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q4a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4a5.setTextColor(resources.getColor(R.color.LightText))

        }
    }

    private fun setNav() {
        viewBinding.navigateBtn.setOnClickListener {
            findNavController().navigate("second") {
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