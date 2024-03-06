package com.graduation.breastcancer.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.graduation.breastcancer.databinding.ActivityHomeBinding
import com.graduation.breastcancer.ui.authentication.host.RegestraionCycleActivity
import com.graduation.breastcancer.ui.mlmodel.ModelActivity
import com.graduation.breastcancer.ui.questions.ActivityQuestionCycle
import com.graduation.breastcancer.ui.reports.ReportForNoCancerActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomeBinding
    val auth = FirebaseAuth.getInstance()
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
        viewBinding.logoutTv.setOnClickListener {
            handleLogout()
        }
    }

    private fun handleLogout() {
        auth.signOut()
        navigateToLogin()
    }

    private fun navigateToLogin() {
        val intent = Intent(this, RegestraionCycleActivity::class.java)
        startActivity(intent)
        finish()
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
        val intent = Intent(this, ReportForNoCancerActivity::class.java)
        startActivity(intent)
    }
}