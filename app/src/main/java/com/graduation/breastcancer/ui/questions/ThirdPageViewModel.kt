package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.breastcancer.data.ThirdData

class ThirdPageViewModel : ViewModel() {
    var prevTreatAnswer = false
    var prevTreatType: String? = null
    val prevTreatTypeError = MutableLiveData<String>()
    var treatForOtherAnswer = false
    var prevBirthConAnswer = false
    val prevBirthDuration = MutableLiveData<String>()
    val prevBirthDurationError = MutableLiveData<String>()
    var haveHarmoneyRepAnswer = false
    val navigate = MutableLiveData<Boolean>()
    val userData = MutableLiveData<ThirdData>()
    fun insertData() {
        if (!isValid()) {
            return
        }
        try {
            userData.postValue(
                ThirdData(
                    breastTreatment = prevTreatAnswer,
                    breastTreatmentType = prevTreatType,
                    takeBirthControl = prevBirthConAnswer,
                    birthControlDuration = prevBirthDuration.value,
                    nonBreastTreatment = treatForOtherAnswer,
                    otherHermonyTreat = treatForOtherAnswer
                )
            )
            navigate.postValue(true)
        } catch (e: Exception) {
            navigate.postValue(false)
        }
    }

    fun isValid(): Boolean {
        var valid = true
        if (prevTreatAnswer) {
            if (prevTreatType.isNullOrBlank()) {
                valid = false
                prevTreatTypeError.postValue("Required")
            } else {
                valid = true
                prevTreatTypeError.postValue("")
            }
        }
        if (prevTreatAnswer) {
            if (prevBirthConAnswer) {
                if (prevBirthDuration.value.isNullOrBlank()) {
                    valid = false
                    prevBirthDurationError.postValue("Required")
                } else {
                    valid = true
                    prevBirthDurationError.postValue("")
                }
            }
        }

        return valid
    }

    fun getPrevTreatAnswer(answer: Boolean) {
        this.prevTreatAnswer = answer
    }

    fun getPrevRadiational(answer: Boolean) {
        this.treatForOtherAnswer = answer
    }

    fun getBirthControlAnswer(answer: Boolean) {
        this.prevBirthConAnswer = answer
    }

    fun getOtherHarmoneyAnswer(answer: Boolean) {
        this.haveHarmoneyRepAnswer = answer
    }

    fun getBreastTreatmentType(type: String) {
        this.prevTreatType = type
    }


}