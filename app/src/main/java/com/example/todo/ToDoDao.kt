package com.example.todo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insert(note:Todo)

    @Delete
   suspend fun delete(note:Todo)

    @Query("Select * from Todo_table order by id ASC")

    fun getAllList(): LiveData<List<Todo>>
}