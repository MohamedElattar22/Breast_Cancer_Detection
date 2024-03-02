package com.graduation.breastcancer.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.graduation.breastcancer.databinding.ActivityAppLanguageBinding
import com.graduation.breastcancer.ui.authentication.host.RegestraionCycleActivity
import com.graduation.breastcancer.ui.home.HomeActivity
import java.util.Locale

class AppLanguageActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAppLanguageBinding
    private lateinit var local: Locale
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
        val pref = getSharedPreferences("language", MODE_PRIVATE)
        val lang = pref.getString("language", "")

        if (lang == "ar") {
            setLocal(lang)
        } else if (lang == "en") {
            setLocal(lang)
        }

    }

    private fun initViews() {
        viewBinding.Arabic.setOnClickListener {
            setLocal("ar")
            val pref = getSharedPreferences("language", MODE_PRIVATE)
            val edit = pref.edit()
            edit.putString("language", "ar")
            edit.apply()
            navigateToGetStarted()
        }
        viewBinding.English.setOnClickListener {
            setLocal("en")
            val pref = getSharedPreferences("language", MODE_PRIVATE)
            val edit = pref.edit()
            edit.putString("language", "en")
            edit.apply()
            navigateToGetStarted()
        }

    }


    private fun setLocal(lang: String) {
        local = Locale(lang)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = local
        res.updateConfiguration(conf, dm)
    }

    private fun navigateToGetStarted() {
        val intent = Intent(this, RegestraionCycleActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}