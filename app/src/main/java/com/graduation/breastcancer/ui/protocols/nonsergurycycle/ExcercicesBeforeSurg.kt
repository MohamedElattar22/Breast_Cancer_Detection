package com.graduation.breastcancer.ui.protocols.nonsergurycycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graduation.breastcancer.databinding.ActivityExcercicesBeforeSurgBinding

class ExcercicesBeforeSurg : AppCompatActivity() {
    private lateinit var viewBinding: ActivityExcercicesBeforeSurgBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityExcercicesBeforeSurgBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()

    }

    private fun initViews() {
        val player1 = viewBinding.youtubePlayerView1
        lifecycle.addObserver(player1)
        val player2 = viewBinding.youtubePlayerView3
        lifecycle.addObserver(player2)
        val player3 = viewBinding.youtubePlayerView4
        lifecycle.addObserver(player3)
    }
}