package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.breastcancer.data.EighthData
import com.graduation.breastcancer.data.FifthData
import com.graduation.breastcancer.data.FirstData
import com.graduation.breastcancer.data.FourthData
import com.graduation.breastcancer.data.SecondData
import com.graduation.breastcancer.data.SeventhData
import com.graduation.breastcancer.data.SixthData
import com.graduation.breastcancer.data.ThirdData
import com.graduation.breastcancer.data.UserData

class ResultViewModel : ViewModel() {
    private var firstPageData: FirstData? = null
    private var secondPageData: SecondData? = null
    private var thirdPageData: ThirdData? = null
    private var fourthPageData: FourthData? = null
    private var fifthPageData: FifthData? = null
    private var sixthPageData: SixthData? = null
    private var seventhPageData: SeventhData? = null
    private var eighthPageData: EighthData? = null
    val userData = MutableLiveData<UserData>()

    fun fillDataOfUser(): UserData {

        return UserData(
            userName = firstPageData?.userName,
            gender = firstPageData?.gender,
            age = firstPageData?.age,
            regionAddress = firstPageData?.regionAddress,
            currentAddress = firstPageData?.currentAddress,
            maritalStatus = firstPageData?.maritalStatus,
            numberOfRelatives = secondPageData?.numberOfRelatives,
            relativeHasCancer = secondPageData?.isRealativeHasCancer!!,
            relativeGender = secondPageData?.relativeGender,
            relationalDeg = secondPageData?.relationalDeg,
            ageOfDia = secondPageData?.ageOfDia,
            otherSymp = secondPageData?.otherSymp,
            breastTreatment = thirdPageData?.breastTreatment!!,
            breastTreatmentType = thirdPageData?.breastTreatmentType,
            nonBreastTreatment = thirdPageData?.nonBreastTreatment!!,
            takeBirthControl = thirdPageData?.takeBirthControl!!,
            birthControlDuration = thirdPageData?.birthControlDuration,
            otherHermonyTreat = thirdPageData?.otherHermonyTreat,
            firstChildAge = fourthPageData?.firstChildAge,
            lastChildAge = fourthPageData?.lastChildAge,
            firstCycleAge = fourthPageData?.firstCycleAge,
            menopause = fourthPageData?.menopause,
            naturalMilk = fifthPageData?.naturalMilk!!,
            doExecrcise = fifthPageData?.doExecrcise!!,
            overWeight = fifthPageData?.overWeight!!,
            race = fifthPageData?.race,
            isSmoker = fifthPageData?.isSmoker!!,
            isFamilyMemSmoker = fifthPageData?.isFamilyMemSmoker!!,
            jackDanielsDrinker = fifthPageData?.jackDanielsDrinker!!,
            strangePieces = sixthPageData?.strangePieces,
            isPiecesHard = sixthPageData?.isPiecesHard,
            isPiecesSlowlyGrow = sixthPageData?.isPiecesSlowlyGrow,
            isPiecesMeanders = sixthPageData?.isPiecesMeanders,
            isPiecesPainful = sixthPageData?.isPiecesPainful,
            isThereOrange = seventhPageData?.isThereOrange!!,
            isThereRedPoints = seventhPageData?.isThereRedPoints!!,
            isThereBloody = seventhPageData?.isThereBloody!!,
            isItchy = seventhPageData?.isItchy!!,
            isInside = seventhPageData?.isInside!!,
            isExcreted = eighthPageData?.isExcreted!!,
            isClothesDirt = eighthPageData?.isClothesDirt!!,
            isContentious = eighthPageData?.isContentious!!,
            isExcretedBloody = eighthPageData?.isExcretedBloody!!,
            nto2 = eighthPageData?.nto2!!,
            nonPregnant = eighthPageData?.nonPregnant!!,
            painful = eighthPageData?.painful!!

        )
    }

    fun getFirstPageAnswer(data: FirstData) {
        this.firstPageData = data
    }

    fun getSecondPageAnswer(data: SecondData) {
        this.secondPageData = data
    }

    fun getThirdPageAnswer(data: ThirdData) {
        this.thirdPageData = data
    }

    fun getFourthPageAnswer(data: FourthData) {
        this.fourthPageData = data

    }

    fun getFifthPageAnswer(data: FifthData) {
        this.fifthPageData = data
    }

    fun getSixthPageAnswer(data: SixthData) {
        this.sixthPageData = data
    }

    fun getSeventhPageAnswer(data: SeventhData) {
        this.seventhPageData = data
    }

    fun getEighthPageAnswer(data: EighthData) {
        this.eighthPageData = data
    }

}