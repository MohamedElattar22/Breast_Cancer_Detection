package com.graduation.breastcancer.ui.reports

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graduation.breastcancer.databinding.ActivityReportForNoCancerBinding

class ReportForNoCancerActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityReportForNoCancerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReportForNoCancerBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {

    }
}