package com.graduation.breastcancer.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graduation.breastcancer.databinding.ActivityHomeBinding
import com.graduation.breastcancer.ui.mlmodel.ModelActivity
import com.graduation.breastcancer.ui.protocols.nonsergurycycle.NonSerguryProtocol
import com.graduation.breastcancer.ui.questions.ActivityQuestionCycle

class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        viewBinding.reports.setOnClickListener {
            navigateToProtocols()
        }
        viewBinding.newreport.setOnClickListener {
            navigateToReportQuestionCycle()
        }
        viewBinding.tryNowBtn.setOnClickListener {
            navigateToModelPage()
        }
    }

    private fun navigateToModelPage() {
        val intent = Intent(this, ModelActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToReportQuestionCycle() {
        val intent = Intent(this, ActivityQuestionCycle::class.java)
        startActivity(intent)
    }

    private fun navigateToProtocols() {
        val intent = Intent(this, NonSerguryProtocol::class.java)
        startActivity(intent)
    }
}