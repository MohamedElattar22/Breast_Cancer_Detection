package com.graduation.breastcancer.ui.protocols.nonsergurycycle.questionsfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.graduation.breastcancer.R
import com.graduation.breastcancer.databinding.FragmentNonQuesThirdPageBinding


class NonQuesThirdPage : Fragment() {
    private lateinit var viewBinding: FragmentNonQuesThirdPageBinding
    var temp1 = 1
    var temp2 = 1
    var temp3 = 1
    var temp4 = 1
    var temp5 = 1
    var temp6 = 1
    var temp7 = 1
    var temp_1 = 1
    var temp2_1 = 1
    var temp3_1 = 1
    var temp4_1 = 1
    var temp5_1 = 1
    var temp6_1 = 1
    var temp7_1 = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentNonQuesThirdPageBinding.inflate(inflater, container, false)
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
        setNav()
    }

    private fun setFirstQuestion() {
        viewBinding.q1.setOnClickListener {
            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q1.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q2.setOnClickListener {
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q6.setTextColor(resources.getColor(R.color.LightText))

        }

        viewBinding.q3.setOnClickListener {
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q4.setOnClickListener {
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q4.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q5.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q5.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q5.setOnClickListener {
            viewBinding.q5.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q5.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q6.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q6.setTextColor(resources.getColor(R.color.LightText))

        }
        viewBinding.q6.setOnClickListener {
            viewBinding.q6.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q6.setTextColor(resources.getColor(R.color.white))

            viewBinding.q1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q5.setBackgroundColor(resources.getColor(R.color.white))

            viewBinding.q1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q5.setTextColor(resources.getColor(R.color.LightText))

        }
    }

    private fun setSecondQuestion() {
        viewBinding.q2a1.setOnClickListener {
            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a1.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a5.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a5.setTextColor(resources.getColor(R.color.LightText))


        }
        viewBinding.q2a2.setOnClickListener {
            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a2.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a5.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a5.setTextColor(resources.getColor(R.color.LightText))


        }

        viewBinding.q2a3.setOnClickListener {
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a4.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a5.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a4.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a5.setTextColor(resources.getColor(R.color.LightText))


        }
        viewBinding.q2a4.setOnClickListener {
            viewBinding.q2a4.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a4.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a5.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a5.setTextColor(resources.getColor(R.color.LightText))


        }
        viewBinding.q2a5.setOnClickListener {
            viewBinding.q2a5.setBackgroundColor(resources.getColor(R.color.MainColor))
            viewBinding.q2a5.setTextColor(resources.getColor(R.color.white))

            viewBinding.q2a1.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a2.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a3.setBackgroundColor(resources.getColor(R.color.white))
            viewBinding.q2a4.setBackgroundColor(resources.getColor(R.color.white))


            viewBinding.q2a1.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a2.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a3.setTextColor(resources.getColor(R.color.LightText))
            viewBinding.q2a4.setTextColor(resources.getColor(R.color.LightText))


        }

    }

    private fun setThirdQuestion() {
        viewBinding.q3a1.setOnClickListener {
            if (temp1 == 1) {
                viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q3a1.setTextColor(resources.getColor(R.color.white))
                Log.d("temp", temp1.toString())
                temp1 = 0
            } else if (temp1 == 0) {
                viewBinding.q3a1.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q3a1.setTextColor(resources.getColor(R.color.LightText))
                temp1 = 1
                Log.d("temp", temp1.toString())
            }

        }
        viewBinding.q3a2.setOnClickListener {
            if (temp2 == 1) {
                viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q3a2.setTextColor(resources.getColor(R.color.white))
                temp2 = 0
            } else if (temp2 == 0) {
                viewBinding.q3a2.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q3a2.setTextColor(resources.getColor(R.color.LightText))
                temp2 = 1

            }


        }

        viewBinding.q3a3.setOnClickListener {
            if (temp3 == 1) {
                viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q3a3.setTextColor(resources.getColor(R.color.white))
                temp3 = 0
            } else if (temp3 == 0) {
                viewBinding.q3a3.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q3a3.setTextColor(resources.getColor(R.color.LightText))
                temp3 = 1

            }

        }
        viewBinding.q3a4.setOnClickListener {
            if (temp4 == 1) {
                viewBinding.q3a4.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q3a4.setTextColor(resources.getColor(R.color.white))
                temp4 = 0
            } else if (temp4 == 0) {
                viewBinding.q3a4.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q3a4.setTextColor(resources.getColor(R.color.LightText))
                temp4 = 1

            }

        }
        viewBinding.q3a5.setOnClickListener {
            if (temp5 == 1) {
                viewBinding.q3a5.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q3a5.setTextColor(resources.getColor(R.color.white))
                temp5 = 0
            } else if (temp5 == 0) {
                viewBinding.q3a5.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q3a5.setTextColor(resources.getColor(R.color.LightText))
                temp5 = 1

            }

        }
        viewBinding.q3a6.setOnClickListener {
            if (temp6 == 1) {
                viewBinding.q3a6.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q3a6.setTextColor(resources.getColor(R.color.white))
                temp6 = 0
            } else if (temp6 == 0) {
                viewBinding.q3a6.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q3a6.setTextColor(resources.getColor(R.color.LightText))
                temp6 = 1

            }

        }
        viewBinding.q3a7.setOnClickListener {
            if (temp7 == 1) {
                viewBinding.q3a7.setBackgroundColor(resources.getColor(R.color.MainColor))
                viewBinding.q3a7.setTextColor(resources.getColor(R.color.white))
                temp7 = 0
            } else if (temp7 == 0) {
                viewBinding.q3a7.setBackgroundColor(resources.getColor(R.color.white))
                viewBinding.q3a7.setTextColor(resources.getColor(R.color.LightText))
                temp7 = 1

            }

        }
    }



    private fun setNav() {
        viewBinding.nextBtn.setOnClickListener {
            findNavController().navigate("fourth") {
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