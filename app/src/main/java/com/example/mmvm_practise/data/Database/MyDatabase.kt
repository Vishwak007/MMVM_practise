package com.example.mmvm_practise.data.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDaoM():UserDaoM

    companion object{
        private var databaseInst:MyDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context:Context):MyDatabase?{
            if (databaseInst != null){
                synchronized(MyDatabase::class){
                    databaseInst = Room.databaseBuilder(context.applicationContext,
                        MyDatabase::class.java, "user.db").allowMainThreadQueries().build()
                }
            }
            return databaseInst
        }
        fun destroyInstance():Unit{
            databaseInst = null
        }
    }
}