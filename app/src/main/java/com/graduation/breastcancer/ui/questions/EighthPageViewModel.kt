package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.breastcancer.data.EighthData

class EighthPageViewModel : ViewModel() {

    private var isExcretedAns: Boolean = false
    private var isClothesDirtAns: Boolean = false
    private var isContentiousAns: Boolean = false
    private var isExcretedBloodyAns: Boolean = false
    private var nto2Ans: Boolean = false
    private var nonPregnantAns: Boolean = false
    private var painfulAns: Boolean = false
    val navigate = MutableLiveData<Boolean>()
    val userData = MutableLiveData<EighthData>()

    fun insertData() {
        try {
            userData.postValue(
                EighthData(
                    isClothesDirt = isClothesDirtAns,
                    isExcreted = isExcretedAns,
                    isContentious = isContentiousAns,
                    isExcretedBloody = isExcretedBloodyAns,
                    nto2 = nto2Ans,
                    nonPregnant = nonPregnantAns,
                    painful = painfulAns
                )
            )
            navigate.postValue(true)
        } catch (e: Exception) {
            navigate.postValue(false)
        }
    }

    fun getIsExcretedAns(answer: Boolean) {
        this.isExcretedAns = answer
    }

    fun getIsClothesDirtAns(answer: Boolean) {
        this.isClothesDirtAns = answer
    }

    fun getIsContentiousAns(answer: Boolean) {
        this.isContentiousAns = answer
    }

    fun getIsExcretedBloodyAns(answer: Boolean) {
        this.isExcretedBloodyAns = answer
    }

    fun getNto2Ans(answer: Boolean) {
        this.nto2Ans = answer
    }

    fun getIsNonPregnantAns(answer: Boolean) {
        this.nonPregnantAns = answer
    }

    fun getIsPainfulAns(answer: Boolean) {
        this.painfulAns = answer
    }


}