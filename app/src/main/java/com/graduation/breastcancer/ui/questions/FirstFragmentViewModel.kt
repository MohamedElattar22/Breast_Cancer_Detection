package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstFragmentViewModel : ViewModel() {
    var maritalStatus: String? = null
    var gender: String? = null
    val errorName = MutableLiveData<String?>()
    val errorAge = MutableLiveData<String?>()
    val maritalStatusError = MutableLiveData<String?>()
    val genderError = MutableLiveData<String?>()
    val errorFirstAddress = MutableLiveData<String?>()
    val errorRegionAddress = MutableLiveData<String?>()
    val Name = MutableLiveData<String>()
    val Age = MutableLiveData<String>()
    val FirstAddress = MutableLiveData<String>()
    val RegionAddress = MutableLiveData<String>()
    var regionAddressAnswer = false

    fun insertData() {
        if (!isValid()) {
            return
        }

    }

    private fun isValid(): Boolean {
        var valid = true
        if (Name.value.isNullOrBlank()) {
            valid = false
            errorName.postValue("Required")
        } else {
            errorName.postValue(null)
        }
        if (Age.value.isNullOrBlank()) {
            valid = false
            errorAge.postValue("Required")
        } else {
            errorAge.postValue(null)
        }
        if (FirstAddress.value.isNullOrBlank()) {
            valid = false
            errorFirstAddress.postValue("Required")
        } else {
            errorFirstAddress.postValue(null)
        }
        if (regionAddressAnswer) {
            if (RegionAddress.value.isNullOrBlank()) {
                valid = false
                errorRegionAddress.postValue("Required")
            } else {
                errorRegionAddress.postValue(null)
            }
        }
        if (maritalStatus.isNullOrBlank()) {
            valid = false
            maritalStatusError.postValue("Required")
        } else {
            maritalStatusError.postValue(null)
        }
        if (gender.isNullOrBlank()) {
            valid = false
            genderError.postValue("Required")
        } else {
            genderError.postValue(null)
        }


        return valid
    }

    fun getGender(gender: String) {
        this.gender = gender
    }

    fun getMaritalStatus(maritalStatus: String?) {
        this.maritalStatus = maritalStatus
    }

    fun getRegionAddressAnswer(regionAddressAnswer :Boolean) {
        this.regionAddressAnswer = regionAddressAnswer
    }


}