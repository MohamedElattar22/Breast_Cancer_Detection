package com.graduation.breastcancer.ui.questions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graduation.breastcancer.databinding.ActivityQuestionCycleBinding

class ActivityQuestionCycle : AppCompatActivity() {
    private lateinit var viewBinding: ActivityQuestionCycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityQuestionCycleBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {

    }
}