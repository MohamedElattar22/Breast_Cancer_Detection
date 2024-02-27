package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstFragmentViewModel : ViewModel() {
    val maritalStatus: String? = null
    val errorName = MutableLiveData<String>()
    val errorAge = MutableLiveData<String>()
    val errorFirstAddress = MutableLiveData<String>()
    val errorRegionAddress = MutableLiveData<String>()
    val Name = MutableLiveData<String>()
    val Age = MutableLiveData<String>()
    val FirstAddress = MutableLiveData<String>()
    val RegionAddress = MutableLiveData<String>()
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
        if (RegionAddress.value.isNullOrBlank()) {
            valid = false
            errorRegionAddress.postValue("Required")
        } else {
            errorRegionAddress.postValue("")
        }
        return valid
    }

    fun getGender() {

    }

    fun getMaritalStatus() {

    }


}