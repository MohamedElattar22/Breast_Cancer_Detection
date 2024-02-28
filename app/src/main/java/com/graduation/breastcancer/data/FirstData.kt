package com.graduation.breastcancer.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FirstData(
    var userName: String? = null,
    var gender: String? = null,
    var age: String? = null,
    var regionAddress: String? = null,
    var currentAddress: String? = null,
    var maritalStatus: String? = null
) : Parcelable
