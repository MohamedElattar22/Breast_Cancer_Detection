package com.graduation.breastcancer.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//@Entity("Reports")
@Parcelize
data class UserData(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "ID")
//    var id: Int? = null,
    var userName: String? = null,
    var gender: String? = null,
    var age: String? = null,
    var regionAddress: String? = null,
    var currentAddress: String? = null,
    var maritalStatus: String? = null,
    var relativeHasCancer: Boolean = false,
    var numberOfRelatives: String? = null,
    var relativeGender: String? = null,
    var relationalDeg: String? = null,
    var ageOfDia: String? = null,
    var otherSymp: String? = null,
    var breastTreatment: Boolean = false,
    var breastTreatmentType: String? = null,
    var nonBreastTreatment: Boolean = false,
    var takeBirthControl: Boolean = false,
    var birthControlDuration: String? = null,
    var otherHermonyTreat: Boolean? = false,
    var firstChildAge: String? = null,
    var lastChildAge: String? = null,
    var firstCycleAge: String? = null,
    var menopause: String? = null,
    var naturalMilk: Boolean = false,
    var doExecrcise: Boolean = false,
    var overWeight: Boolean = false,
    var race: String? = null,
    var isSmoker: Boolean = false,
    var isFamilyMemSmoker: Boolean = false,
    var jackDanielsDrinker: Boolean = false
) : Parcelable