package com.example.mmvm_practise.data.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDaoM {
    @Query("Select * from user")
    suspend fun getAllUsers():List<User>     //use suspend function if you want to run it inside coroutines

    @Query("Select firstName, lastName from user where userName LIKE :userN")
    suspend fun getFullname(userN:String):FullName

    @Query("Select * from user where Gender LIKE :gend")
    suspend fun getViaGender(gend:String):List<User>

    @Query("Select * from user where userName IN (:listOfUserName)")
    suspend fun getUserDetailFromListOfUsername(listOfUserName:List<String>):List<User>

    @Insert
    suspend fun addUser(vararg user: User)

    @Insert
    suspend fun addBothUser(user1:User, user2:User)

    @Insert
    suspend fun addAllUser(userList: Array<User>)

    @Update
    suspend fun updateUser(vararg user:User)

    @Delete
    suspend fun deleteUser(vararg user: User)
}