package com.graduation.breastcancer.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.graduation.breastcancer.data.UserData

@Dao
interface ReportDao {
    @Insert
    fun insertQuestionData(userData: UserData)

    @Query("Select * from reports")
    fun getAllReports(): List<UserData>

}