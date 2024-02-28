package com.graduation.breastcancer.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FourthData(
    var firstChildAge: String? = null,
    var lastChildAge: String? = null,
    var firstCycleAge: String? = null,
    var menopause: String? = null
) : Parcelable
