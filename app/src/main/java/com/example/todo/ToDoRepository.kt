package com.example.todo

import androidx.lifecycle.LiveData

class ToDoRepository(private val todoDao: ToDoDao) {

    val allLists: LiveData<List<Todo>> = todoDao.getAllList()

    suspend fun insert(todo:Todo) {
        todoDao.insert(todo)
    }
    suspend fun  delete(todo:Todo) {
        todoDao.delete(todo)
    }

}