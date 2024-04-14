package com.graduation.breastcancer.ui.reports

import android.content.Context
import android.content.Intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.graduation.breastcancer.data.ModelResults
import com.graduation.breastcancer.data.UserData
import com.graduation.breastcancer.databinding.ActivityReportForNoCancerBinding
import com.graduation.mawruth.ui.home.ReportsAdapter

class ReportForNoCancerActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityReportForNoCancerBinding
    private val adapter = ReportsAdapter(listOf(), listOf())
    private val modelAnswerList = mutableListOf<ModelResults>()
    private val list = mutableListOf<UserData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReportForNoCancerBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        generateList()
        adapter.bindMuseumsList(list, modelAnswerList)
        viewBinding.Rv.adapter = adapter

        adapter.onItemClickListener = object : ReportsAdapter.onItemClick {
            override fun onClick(pos: Int, item: UserData, modelResult: ModelResults) {
                val intent = Intent(
                    this@ReportForNoCancerActivity, ReportDetailsActivity::class.java
                )
                intent.putExtra("userData", item)
                intent.putExtra("modelData", modelResult)
                startActivity(intent)
            }

        }

    }

    private fun generateList() {
        val pref = getSharedPreferences("User", Context.MODE_PRIVATE)
        val res = pref.getStringSet("ReportQuestions", mutableSetOf())
        val modelRes = pref.getString("modelAnswer", "")
        val type = object : TypeToken<MutableList<ModelResults>>() {}
        val listJs = Gson().fromJson(modelRes, type)
        res?.forEach {
            val idx = Gson().fromJson(it, UserData::class.java)
            list.add(idx)
        }
        listJs?.forEach {
            modelAnswerList.add(it)
        }

    }
}