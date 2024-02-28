package com.graduation.breastcancer.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.graduation.breastcancer.databinding.ActivityAppLanguageBinding
import com.graduation.breastcancer.ui.authentication.host.RegestraionCycleActivity
import com.graduation.breastcancer.ui.questions.ActivityQuestionCycle
import java.util.Locale

class AppLanguageActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAppLanguageBinding
    lateinit var local: Locale
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAppLanguageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
    }

    override fun onStart() {
        super.onStart()
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        if (user != null) {
            navigateToHome()
        }
    }

    private fun initViews() {
        viewBinding.Arabic.setOnClickListener {
            setLocal("ar")
        }
        viewBinding.English.setOnClickListener {
            setLocal("en")
        }
        viewBinding.nextBtn.setOnClickListener {
            navigateToGetStarted()
        }
    }

    fun setLocal(lang: String) {
        local = Locale(lang)
        var res = resources
        var dm = res.displayMetrics
        var conf = res.configuration
        conf.locale = local
        res.updateConfiguration(conf, dm)
        val refresh = Intent(this, AppLanguageActivity::class.java)
        startActivity(refresh)
        finish()

    }

    fun navigateToGetStarted() {
        val intent = Intent(this, RegestraionCycleActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun navigateToHome() {
        val intent = Intent(this, ActivityQuestionCycle::class.java)
        startActivity(intent)
        finish()
    }
}