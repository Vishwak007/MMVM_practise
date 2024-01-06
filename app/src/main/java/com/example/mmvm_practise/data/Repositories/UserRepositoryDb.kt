package com.example.mmvm_practise.data.Repositories

import android.content.Context
import com.example.mmvm_practise.data.Database.FullName
import com.example.mmvm_practise.data.Database.MyDatabase
import com.example.mmvm_practise.data.Database.User
import com.example.mmvm_practise.data.Database.UserDaoM

class UserRepositoryDb(context: Context) {
    val  db: UserDaoM? = MyDatabase.getInstance(context)?.userDaoM()

    suspend fun getAllUser():List<User>?{
        return db?.getAllUsers()
    }
    suspend fun insertSingleUser(user:User){
        db?.addUser(user)
    }
    suspend fun getFullName(userName:String):FullName?{
        return db?.getFullname(userName)
    }
}