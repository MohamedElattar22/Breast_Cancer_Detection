package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.breastcancer.data.SecondData

class SecondPageViewModel : ViewModel() {
    var relationalDegree: String? = null
    val relationalDegreeError = MutableLiveData<String?>()

    var gender: String = ""
    val genderError = MutableLiveData<String?>()

    val age = MutableLiveData<String>()
    val errorAge = MutableLiveData<String?>()

    val other = MutableLiveData<String>()
    val otherError = MutableLiveData<String?>()

    val numOfRelatives = MutableLiveData<String>()
    val numOfRelativesError = MutableLiveData<String?>()

    var relativeHasCancerAnswer = true
    val userData = MutableLiveData<SecondData>()
    val navigate = MutableLiveData<Boolean>()
    fun insertData() {

        if (!relativeHasCancerAnswer) {
            userData.postValue(
                SecondData(
                    relationalDeg = "non",
                    relativeGender = "non",
                    ageOfDia = "non",
                    otherSymp = "non",
                    numberOfRelatives = "0",
                )
            )
            navigate.postValue(true)
        } else {
            if (!isValid()) {
                navigate.postValue(false)
                return
            }
            try {
                userData.postValue(
                    SecondData(
                        relationalDeg = relationalDegree,
                        relativeGender = gender,
                        ageOfDia = age.value,
                        otherSymp = other.value,
                        numberOfRelatives = numOfRelatives.value,
                    )
                )
                navigate.postValue(true)
            } catch (e: Exception) {
                navigate.postValue(false)
            }


        }


    }

    private fun isValid(): Boolean {
        var valid = true
        if (numOfRelatives.value.isNullOrBlank()) {
            valid = false
            numOfRelativesError.postValue("Required")
        } else {
            numOfRelativesError.postValue("")
        }

        if (gender.isBlank()) {
            valid = false
            genderError.postValue("Required")
        } else {
            genderError.postValue("")
        }

        if (relationalDegree.isNullOrBlank()) {
            valid = false
            relationalDegreeError.postValue("Required")
        } else {
            relationalDegreeError.postValue(null)
        }

        if (other.value.isNullOrBlank()) {
            valid = false
            otherError.postValue("Required")
        } else {

            otherError.postValue("")
        }

        if (age.value.isNullOrBlank()) {
            valid = false
            errorAge.postValue("Required")
        } else {

            errorAge.postValue("")
        }

        if (relativeHasCancerAnswer) {
            if (numOfRelatives.value.isNullOrBlank()) {
                valid = false
                numOfRelativesError.postValue("Required")
            } else {
                numOfRelativesError.postValue("")
            }
        }
        return valid

    }

    fun getGender(gender: String) {
        this.gender = gender
    }

    fun getRelationalDegree(relationalDegree: String) {
        this.relationalDegree = relationalDegree
    }

    fun getRelativesHasCancer(relativeHasCan: Boolean) {
        this.relativeHasCancerAnswer = relativeHasCan
    }


}