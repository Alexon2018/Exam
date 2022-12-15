package com.example.exam.utils

import android.content.Intent
import android.provider.MediaStore.Audio.AudioColumns.TITLE_KEY
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.DetailActivity
import com.example.exam.R

class MyAdapter (val data : List<Int>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val row : View)  : RecyclerView.ViewHolder(row){
        val textView = row.findViewById<TextView>(R.id.number)

        companion object{
            const val KEY_ONE = "aici punem o variabila"
        }

        init{
            row.setOnClickListener {
                val intent = Intent(row.context, DetailActivity::class.java)
                intent.putExtra(KEY_ONE, "abc")
                row.context.startActivity(intent)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = data[position].toString()
    }

    override fun getItemCount(): Int = data.size
}

