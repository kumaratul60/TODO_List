package com.example.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application:Application):AndroidViewModel(application) {


    private val repository:ToDoRepository
    val allLists: LiveData<List<Todo>>

    init {
        val dao = ToDoDatabase.getDatabase(application).getToDoDao()
        repository = ToDoRepository(dao)
        allLists = repository.allLists

    }

    fun deleteTodo(todo:Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(todo)
    }

    fun insertTodo(todo: Todo)= viewModelScope.launch(Dispatchers.IO) {
        repository.insert(todo)
    }


}