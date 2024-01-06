package com.example.mmvm_practise.data.Database

import androidx.room.ColumnInfo

data class FullName(
    @ColumnInfo("firstName") var firstName:String,
    @ColumnInfo("lastName") var lastName:String
)
