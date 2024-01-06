package com.example.mmvm_practise.data.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(@PrimaryKey var id: Int? = null,
    @ColumnInfo("userName") var username: String? = null,
    var email: String? = null,
    @ColumnInfo("firstName") var firstName: String? = null,
    @ColumnInfo("lastName") var lastName: String? = null,
    @ColumnInfo("Gender") var gender: String? = null,
    var image: String? = null,
    var token: String? = null
)
