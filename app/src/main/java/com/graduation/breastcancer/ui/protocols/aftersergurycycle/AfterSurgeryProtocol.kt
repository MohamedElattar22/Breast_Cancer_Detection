package com.graduation.breastcancer.ui.protocols.aftersergurycycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graduation.breastcancer.databinding.ActivityAfterSurgeryProtocolBinding

class AfterSurgeryProtocol : AppCompatActivity() {
    private lateinit var viewBind: ActivityAfterSurgeryProtocolBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityAfterSurgeryProtocolBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        initViews()
    }

    private fun initViews() {

    }
}