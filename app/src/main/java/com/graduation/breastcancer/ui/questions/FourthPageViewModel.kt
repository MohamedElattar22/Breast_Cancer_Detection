package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.breastcancer.data.FourthData

class FourthPageViewModel : ViewModel() {
    val firstChildAge = MutableLiveData<String>()
    val firstChildAgeError = MutableLiveData<String>()
    val lastChildAge = MutableLiveData<String>()
    val lastChildAgeError = MutableLiveData<String>()
    val ageOfFirstCycle = MutableLiveData<String>()
    val ageOfFirstCycleError = MutableLiveData<String>()
    val ageOfLastCycle = MutableLiveData<String>()
    val ageOfLastCycleError = MutableLiveData<String>()
    val nav = MutableLiveData<Boolean>()
    val userData = MutableLiveData<FourthData>()

    fun insertData() {
        if (!isValid()) {
            return
        }
        try {
            userData.postValue(
                FourthData(
                    firstChildAge = firstChildAge.value,
                    lastChildAge = lastChildAge.value,
                    firstCycleAge = ageOfFirstCycle.value,
                    menopause = ageOfLastCycle.value
                )
            )
            nav.postValue(true)
        } catch (e: Exception) {
            nav.postValue(false)
        }
    }


    private fun isValid(): Boolean {
        var valid = true
        if (firstChildAge.value.isNullOrBlank()) {
            valid = false
            firstChildAgeError.postValue("required")
        } else {
            firstChildAgeError.postValue("")
        }
        if (lastChildAge.value.isNullOrBlank()) {
            valid = false
            lastChildAgeError.postValue("required")
        } else {
            lastChildAgeError.postValue("")
        }
        if (ageOfFirstCycle.value.isNullOrBlank()) {
            valid = false
            ageOfFirstCycleError.postValue("required")
        } else {
            ageOfFirstCycleError.postValue("")
        }
        if (ageOfLastCycle.value.isNullOrBlank()) {
            valid = false
            ageOfLastCycleError.postValue("required")
        } else {
            ageOfLastCycleError.postValue("")
        }
        return valid

    }


}