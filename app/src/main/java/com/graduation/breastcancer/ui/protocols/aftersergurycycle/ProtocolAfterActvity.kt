package com.graduation.breastcancer.ui.protocols.aftersergurycycle


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.graduation.breastcancer.databinding.ActivityProtocolAfterActvityBinding



class ProtocolAfterActvity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityProtocolAfterActvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityProtocolAfterActvityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()

    }

    private fun initViews() {
        val player = viewBinding.youtubePlayerView
        lifecycle.addObserver(player)
    }
}