package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.breastcancer.data.FifthData

class FifthPageViewModel : ViewModel() {
    var breadfNaturalAns = false
    var regExerciseAns = false
    var execWeightAns = false
    var race: String? = null
    val raceError = MutableLiveData<String>()
    var isSmokerAns = false
    var isFamilyMemberSmokeAns = false
    var alcoholAns = false
    val userData = MutableLiveData<FifthData>()
    val nav = MutableLiveData<Boolean>()

    fun insertData() {
        if (!isValid()) {
            return
        }
        try {
            userData.postValue(
                FifthData(
                    naturalMilk = breadfNaturalAns,
                    doExecrcise = regExerciseAns,
                    overWeight = execWeightAns,
                    race = race,
                    isSmoker = isSmokerAns,
                    isFamilyMemSmoker = isFamilyMemberSmokeAns,
                    jackDanielsDrinker = alcoholAns
                )
            )
            nav.postValue(true)
        } catch (e: Exception) {
            nav.postValue(false)
        }
    }


    private fun isValid(): Boolean {
        var valid = true
        if (race.isNullOrBlank()) {
            valid = false
            raceError.postValue("Required")
        } else {
            raceError.postValue("")
        }
        return valid
    }

    fun getBreadfNaturalAns(ans: Boolean) {
        this.breadfNaturalAns = ans
    }

    fun getRegExerciseAns(ans: Boolean) {
        this.regExerciseAns = ans
    }

    fun getExecWeightAns(ans: Boolean) {
        this.execWeightAns = ans
    }

    fun getIsSmokerAns(ans: Boolean) {
        this.isSmokerAns = ans
    }

    fun getIsFamilyMemberSmokeAns(ans: Boolean) {
        this.isFamilyMemberSmokeAns = ans
    }

    fun getAlcoholAns(ans: Boolean) {
        this.alcoholAns = ans
    }

    fun getRace(race: String) {
        this.race = race
    }


}