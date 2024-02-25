package com.graduation.breastcancer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.graduation.breastcancer.databinding.ActivityRegestraionCycleBinding

class RegestraionCycleActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityRegestraionCycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityRegestraionCycleBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        WindowCompat.setDecorFitsSystemWindows(window , false)
    }


}