package com.MeryemEroglu.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.MeryemEroglu.myapplication.databinding.FragmentFirstPageBinding


class FirstPage : Fragment() {

    private lateinit var binding: FragmentFirstPageBinding
    private lateinit var myAdapter: ToDoAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstPageBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myList = mutableListOf<Item>()

        myAdapter = ToDoAdapter(myList)
        binding.recyclerview.adapter = myAdapter
        binding.button2.setOnClickListener {
            val title = binding.editTextText.text.toString()
            val description = binding.editTextText2.text.toString()
            if (title.isEmpty() || description.isEmpty()) {

                Toast.makeText(requireContext(), "Eksik alanları doldurunuz!", Toast.LENGTH_SHORT).show()
            } else {
                val newItem = Item(title, description)
                myList.add(newItem)
                myAdapter.notifyDataSetChanged()
                binding.editTextText.text.clear()
                binding.editTextText2.text.clear()
            }
        }
    }


}