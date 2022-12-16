package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam.databinding.ActivityMainBinding
import com.example.exam.dataclasses.MyItem
import com.example.exam.dataclasses.Response
import com.example.exam.utils.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val filteredArray = ArrayList<MyItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        filteredArray.clear()
        var temp = MyItem(
            "Care este ordinea?",
            Response("A", true),
            Response("B", false),
            Response("C", false),
            "Categoria intai",
            "23-12-2022"
        )
        filteredArray+=temp

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter= MyAdapter(filteredArray)
        binding.rv.hasFixedSize()

        binding.fab.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

    }
}