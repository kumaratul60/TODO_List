package com.example.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoRVAdapter(private val context:Context, private val listner:ITodoRVAdapter): RecyclerView.Adapter<TodoRVAdapter.TodoViewHolder>() {

    val allLists = ArrayList<Todo>()

    inner class TodoViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteView =  itemView.findViewById<ImageView>(R.id.deleteButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
     val viewHolder = TodoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_todo,parent,false))
        listner.onItemClicked(allLists[viewHolder.adapterPosition])
        return viewHolder

    }

    override fun getItemCount(): Int {
        return allLists.size

    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = allLists[position]
        holder.textView.text = currentTodo.text

    }

    fun updateList(newList: List<Todo>) {
        allLists.clear()
        allLists.addAll(newList)

        notifyDataSetChanged()
    }

}

interface ITodoRVAdapter {
    fun onItemClicked(todo:Todo)
}