package com.graduation.breastcancer.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SecondData(
    var numberOfRelatives: String? = null,
    var relativeGender: String? = null,
    var relationalDeg: String? = null,
    var ageOfDia: String? = null,
    var otherSymp: String? = null
) : Parcelable
