package com.example.huiltdragger.database.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users")
data class Users(
    var name:String,
    var mobilenumber:String,
    var email:String) : Serializable {

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}