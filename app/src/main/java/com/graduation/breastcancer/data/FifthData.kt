package com.graduation.breastcancer.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FifthData(
    var naturalMilk: Boolean = false,
    var doExecrcise: Boolean = false,
    var overWeight: Boolean = false,
    var race: String? = null,
    var isSmoker: Boolean = false,
    var isFamilyMemSmoker: Boolean = false,
    var jackDanielsDrinker: Boolean = false
) : Parcelable
