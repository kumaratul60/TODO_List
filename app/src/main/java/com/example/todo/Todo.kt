package com.example.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todo_table")
class Todo(@ColumnInfo(name="text")val text:String) {
    @PrimaryKey(autoGenerate = true) var id = 0

}

