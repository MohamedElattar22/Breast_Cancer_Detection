package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.breastcancer.data.SeventhData


class SeventhPageViewModel : ViewModel() {
    private var isThereOrangeAns: Boolean = false
    private var isThereRedPointsAns: Boolean = false
    private var isThereBloodyAns: Boolean = false
    private var isItchyAns: Boolean = false
    private var isInsideAns: Boolean = false
    val navigate = MutableLiveData<Boolean>()
    val userData = MutableLiveData<SeventhData>()
    fun insertData() {
        try {
            userData.postValue(
                SeventhData(
                    isInside = isInsideAns,
                    isItchy = isItchyAns,
                    isThereBloody = isThereBloodyAns,
                    isThereOrange = isThereOrangeAns,
                    isThereRedPoints = isThereRedPointsAns
                )
            )
            navigate.postValue(true)
        } catch (e: Exception) {
            navigate.postValue(false)
        }
    }

    fun getIsThereOrangeAns(answer: Boolean) {
        this.isThereOrangeAns = answer
    }

    fun getIsThereRedPointsAns(answer: Boolean) {
        this.isThereRedPointsAns = answer
    }

    fun getIsThereBloodyAns(answer: Boolean) {
        this.isThereBloodyAns = answer
    }

    fun getIsItchyAns(answer: Boolean) {
        this.isItchyAns = answer
    }

    fun getIsInsideAns(answer: Boolean) {
        this.isInsideAns = answer
    }


}