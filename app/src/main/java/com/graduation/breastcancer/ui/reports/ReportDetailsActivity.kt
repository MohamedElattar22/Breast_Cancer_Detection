package com.graduation.breastcancer.ui.reports

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graduation.breastcancer.data.ModelResults
import com.graduation.breastcancer.data.UserData
import com.graduation.breastcancer.databinding.ActivityReportDetailsBinding
import com.graduation.breastcancer.ui.protocols.aftersergurycycle.AfterSurgeryProtocol
import com.graduation.breastcancer.ui.protocols.nonsergurycycle.NonSurgeryProtocol

class ReportDetailsActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityReportDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReportDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        val userData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("userData", UserData::class.java)
        } else {
            intent.getParcelableExtra("userData") as UserData?
        }
        val modelData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("modelData", ModelResults::class.java)
        } else {
            intent.getParcelableExtra("modelData") as ModelResults?
        }
        viewBinding.userData = userData
        viewBinding.modelResults = modelData
        viewBinding.lifecycleOwner = this

        viewBinding.Protocol.setOnClickListener {
            if (modelData?.protocolType == true) {
                navigateToAfterSurgeryProtocol()
            } else {
                navigateToNonSurgeryProtocol()
            }
        }

    }

    private fun navigateToAfterSurgeryProtocol() {
        val intent = Intent(this, AfterSurgeryProtocol::class.java)
        startActivity(intent)
    }

    private fun navigateToNonSurgeryProtocol() {
        val intent = Intent(this, NonSurgeryProtocol::class.java)
        startActivity(intent)
    }
}