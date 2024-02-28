package com.graduation.breastcancer.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThirdData(
    var breastTreatment: Boolean = false,
    var breastTreatmentType: String? = null,
    var nonBreastTreatment: Boolean = false,
    var takeBirthControl: Boolean = false,
    var birthControlDuration: String? = null,
    var otherHermonyTreat: Boolean? = false
) : Parcelable
