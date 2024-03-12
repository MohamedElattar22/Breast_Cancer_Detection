package com.graduation.breastcancer.ui.protocols.nonsergurycycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graduation.breastcancer.databinding.ActivitySelectExcBinding

class SelectExcActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySelectExcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySelectExcBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()

    }

    private fun initViews() {
        viewBinding.excercicesBtn.setOnClickListener {
            val intent = Intent(this, ExcercicesBeforeSurg::class.java)
            startActivity(intent)
        }
        viewBinding.commonQuestBtn.setOnClickListener {
            val intent = Intent(this, NonSurgeryProtocol::class.java)
            startActivity(intent)
        }
    }
}