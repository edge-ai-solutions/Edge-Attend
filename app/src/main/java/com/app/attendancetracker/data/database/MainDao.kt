package com.app.attendancetracker.data.database

import androidx.room.*
import com.app.attendancetracker.data.model.FaceInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {

    @Query("DELETE FROM FaceInfo")
    fun clear()


    @Query("DELETE FROM FaceInfo WHERE id = :id")
    fun delete(id: Int)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: FaceInfo)


    @Query("SELECT * FROM FaceInfo WHERE id = :id")
    fun face(id: Int): Flow<FaceInfo>


    @Query("SELECT * FROM FaceInfo ")
    fun faces(): Flow<List<FaceInfo>>


    @Query("SELECT * FROM FaceInfo ")
    fun faceList(): List<FaceInfo>

}