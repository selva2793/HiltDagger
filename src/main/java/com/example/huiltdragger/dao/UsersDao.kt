package com.example.huiltdragger.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.huiltdragger.database.pojo.Users

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: Users)



    @Query("SELECT * FROM Users")
    suspend fun getAll(): List<Users>
}