package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.breastcancer.data.FirstData

class FirstFragmentViewModel : ViewModel() {

    var gender: String = ""
    val genderError = MutableLiveData<String?>()

    val Name = MutableLiveData<String>()
    val errorName = MutableLiveData<String?>()

    val Age = MutableLiveData<String>()
    val errorAge = MutableLiveData<String?>()

    var maritalStatus: String? = null
    val maritalStatusError = MutableLiveData<String?>()

    val FirstAddress = MutableLiveData<String>()
    val errorFirstAddress = MutableLiveData<String?>()

    val RegionAddress = MutableLiveData<String>()
    val errorRegionAddress = MutableLiveData<String?>()

    val userData = MutableLiveData<FirstData>()
    val navigate = MutableLiveData(false)


    var regionAddressAnswer = false

    fun insertData() {

        if (!isValid()) {
            return
        }
        try {
            userData.postValue(
                FirstData(
                    userName = Name.value,
                    gender = gender,
                    age = Age.value,
                    currentAddress = FirstAddress.value,
                    regionAddress = RegionAddress.value,
                    maritalStatus = maritalStatus
                )
            )
            navigate.postValue(true)

        } catch (e: Exception) {
            navigate.postValue(false)
        }

    }

    fun a(): Boolean {
        var v = true
        v = !Name.value.isNullOrBlank()
        return v
    }

    private fun isValid(): Boolean {
        var valid = true
        if (Name.value.isNullOrBlank()) {
            valid = false
            errorName.postValue("Required")
        } else {
            errorName.postValue("")
        }
        if (Age.value.isNullOrBlank()) {
            valid = false
            errorAge.postValue("Required")
        } else {
            errorAge.postValue("")
        }
        if (FirstAddress.value.isNullOrBlank()) {
            valid = false
            errorFirstAddress.postValue("Required")
        } else {
            errorFirstAddress.postValue("")
        }
        if (regionAddressAnswer) {
            if (RegionAddress.value.isNullOrBlank()) {
                valid = false
                errorRegionAddress.postValue("Required")
            } else {
                errorRegionAddress.postValue("")
            }
        }
        if (maritalStatus.isNullOrBlank()) {
            valid = false
            maritalStatusError.postValue("Required")
        } else {
            maritalStatusError.postValue(null)
        }
        if (gender.isBlank()) {
            valid = false
            genderError.postValue("Required")
        } else {
            genderError.postValue("")
        }


        return valid
    }

    fun getGender(gender: String) {
        this.gender = gender
    }

    fun getMaritalStatus(maritalStatus: String) {
        this.maritalStatus = maritalStatus
    }

    fun getRegionAddressAnswer(regionAddressAnswer :Boolean) {
        this.regionAddressAnswer = regionAddressAnswer
    }


}