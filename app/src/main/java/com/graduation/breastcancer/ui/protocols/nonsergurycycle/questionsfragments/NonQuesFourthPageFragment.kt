package com.graduation.breastcancer.ui.protocols.nonsergurycycle.questionsfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.graduation.breastcancer.R

/**
 * A simple [Fragment] subclass.
 * Use the [NonQuesFourthPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NonQuesFourthPageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_non_ques_fourth_page, container, false)
    }

}