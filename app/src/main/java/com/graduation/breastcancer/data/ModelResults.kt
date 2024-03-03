package com.graduation.breastcancer.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelResults(
    val modelRes: String? = null,
    val protocolType: Boolean = false
) : Parcelable
