package com.graduation.breastcancer.ui.splash

import android.content.Intent

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.graduation.breastcancer.databinding.ActivityMainBinding
import com.graduation.breastcancer.ui.authentication.host.RegestraionCycleActivity

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        startSplash()
    }

    private fun startSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, RegestraionCycleActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}