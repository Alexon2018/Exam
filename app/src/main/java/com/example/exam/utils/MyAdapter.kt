package com.example.exam.utils

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.DetailActivity
import com.example.exam.R
import com.example.exam.dataclasses.MyItem

class MyAdapter(private val myList: List<MyItem>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View, var topic : MyItem? = null)  : RecyclerView.ViewHolder(itemView){

        val tvQuestion = itemView.findViewById<TextView>(R.id.idQuestion)
        val tvCategoria = itemView.findViewById<TextView>(R.id.idCategoria)
        val tvDate = itemView.findViewById<TextView>(R.id.idDate)
        val tvCheck = itemView.findViewById<TextView>(R.id.idNumber)


        companion object{
            const val KEY_ONE = "aici punem o variabila"
        }

        init{
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(KEY_ONE, "abc")
                itemView.context.startActivity(intent)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = myList[position]

        holder.tvQuestion.text  = currentItem.question
        holder.tvCategoria.text = currentItem.category
        holder.tvDate.text      = currentItem.currentDate

//        holder.textView.text = data[position].toString()
    }

    override fun getItemCount(): Int = myList.size
}

