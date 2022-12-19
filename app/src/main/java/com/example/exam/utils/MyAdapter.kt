package com.example.exam.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.ViewModels.mainViewModel
import com.example.exam.dataclasses.MyItem

class MyAdapter(private val myList: List<MyItem>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View, var topic : MyItem? = null)  : RecyclerView.ViewHolder(itemView){

        val tvQuestion = itemView.findViewById<TextView>(R.id.idQuestion)
        val tvCategoria = itemView.findViewById<TextView>(R.id.idCategoria)
        val tvDate = itemView.findViewById<TextView>(R.id.idDate)
        val tvCheck = itemView.findViewById<TextView>(R.id.idCheck)

        companion object{
            const val KEY_Question  = "aici punem intrebarea"
            const val KEY_Category  = "aici punem categoria"
            const val KEY_Date      = "aici punem data"
            const val KEY_R1        = "aici punem raspunsul 1"
            const val KEY_R1_bool   = "aici punem bool pt R1"
            const val KEY_R2        = "aici punem raspunsul 2"
            const val KEY_R2_bool   = "aici punem bool pt R2"
            const val KEY_R3        = "aici punem raspunsul 3"
            const val KEY_R3_bool   = "aici punem bool pt R3"
        }

        init{
            itemView.setOnClickListener {
                    view : View ->
                view.findNavController().navigate(R.id.action_itemListFragment_to_addItemFragment)

                mainViewModel().getData()

//                val intent = Intent(itemView.context, DetailActivity::class.java)
//                intent.putExtra(KEY_Question,   topic?.question)
//                intent.putExtra(KEY_Category,   topic?.category)
//                intent.putExtra(KEY_Date,       topic?.currentDate)
//                intent.putExtra(KEY_R1,         topic?.response1?.response)
//                intent.putExtra(KEY_R1_bool,    topic?.response1?.valid)
//                intent.putExtra(KEY_R2,         topic?.response2?.response)
//                intent.putExtra(KEY_R2_bool,    topic?.response2?.valid)
//                intent.putExtra(KEY_R3,         topic?.response3?.response)
//                intent.putExtra(KEY_R3_bool,    topic?.response3?.valid)
//                itemView.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = myList[position]
        holder.tvQuestion.text  = currentItem.question
        holder.tvCategoria.text = currentItem.category
        holder.tvDate.text      = currentItem.currentDate

        holder.topic            = currentItem

    }

    override fun getItemCount(): Int = myList.size
}

