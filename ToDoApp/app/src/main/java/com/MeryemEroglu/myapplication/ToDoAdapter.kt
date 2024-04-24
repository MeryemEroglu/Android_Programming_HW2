package com.MeryemEroglu.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.MeryemEroglu.myapplication.databinding.ItemBinding


class ToDoAdapter(private val list: MutableList<Item>): RecyclerView.Adapter<ToDoAdapter.MyListViewHolder>() {

    inner class MyListViewHolder(private val binding: ItemBinding ):RecyclerView.ViewHolder(binding.root){
        fun bind(getList: Item){
            binding.textView.text = getList.title
            binding.textView3.text = getList.description
            binding.imageButton2.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    list.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyListViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}