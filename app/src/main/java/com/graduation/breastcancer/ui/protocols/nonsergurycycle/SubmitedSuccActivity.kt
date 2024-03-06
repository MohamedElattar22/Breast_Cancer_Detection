package com.graduation.breastcancer.ui.protocols.nonsergurycycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graduation.breastcancer.databinding.ActivitySubmitedSuccBinding
import com.graduation.breastcancer.ui.home.HomeActivity

class SubmitedSuccActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySubmitedSuccBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySubmitedSuccBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.toRegisterBtn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}