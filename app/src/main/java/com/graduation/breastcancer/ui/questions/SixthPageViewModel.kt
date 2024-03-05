package com.graduation.breastcancer.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.breastcancer.data.SixthData

class SixthPageViewModel : ViewModel() {

    private var strangePiecesAns: Boolean? = false
    private var isPiecesHardAns: Boolean? = false
    private var isPiecesSlowlyGrowAns: Boolean? = false
    private var isPiecesMeandersAns: Boolean? = false
    private var isPiecesPainfulAns: Boolean? = false
    val navigate = MutableLiveData<Boolean>()
    val userData = MutableLiveData<SixthData>()

    fun insertData() {

        try {
            userData.postValue(
                SixthData(
                    strangePieces = strangePiecesAns,
                    isPiecesHard = isPiecesHardAns,
                    isPiecesSlowlyGrow = isPiecesSlowlyGrowAns,
                    isPiecesMeanders = isPiecesMeandersAns,
                    isPiecesPainful = isPiecesPainfulAns

                )
            )
            navigate.postValue(true)
        } catch (e: Exception) {
            navigate.postValue(true)
        }
    }

    fun getStrangePiecesAns(answer: Boolean) {
        this.strangePiecesAns = answer
    }

    fun getIsPiecesHardAns(answer: Boolean) {
        this.isPiecesHardAns = answer
    }

    fun getIsPiecesSlowlyGrowAns(answer: Boolean) {
        this.isPiecesSlowlyGrowAns = answer
    }

    fun getIsPiecesMeandersAns(answer: Boolean) {
        this.isPiecesMeandersAns = answer
    }

    fun getIsPiecesPainfulAns(answer: Boolean) {
        this.isPiecesPainfulAns = answer
    }
}