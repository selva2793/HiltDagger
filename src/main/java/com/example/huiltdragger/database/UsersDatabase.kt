package com.example.huiltdragger.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.huiltdragger.dao.UsersDao
import com.example.huiltdragger.database.pojo.Users

@Database(entities = [Users::class],version = 2,exportSchema = false)
abstract class  UsersDatabase : RoomDatabase() {

    abstract fun getDao():UsersDao

    companion object{

        private const val DATABASE_NAME="NoteDatabase"

        @Volatile
        var instance:UsersDatabase?=null

        fun getInstance(context: Context):UsersDatabase?
        {
            if(instance == null)
            {
                synchronized(UsersDatabase::class.java)
                {
                    if(instance == null)
                    {
                        instance= Room.databaseBuilder(context,UsersDatabase::class.java,
                            DATABASE_NAME).build()
                    }
                }
            }
            return instance
        }
    }
}