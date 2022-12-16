package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.exam.databinding.ActivityDetailBinding
import com.example.exam.databinding.ActivityMainBinding
import com.example.exam.utils.MyAdapter

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//variabile care vin pe Intent
        var id1 = intent.getStringExtra(MyAdapter.MyViewHolder.KEY_Question)
        var id2 = intent.getStringExtra(MyAdapter.MyViewHolder.KEY_Category)
        var id3 = intent.getStringExtra(MyAdapter.MyViewHolder.KEY_Date)
        var id4 = intent.getStringExtra(MyAdapter.MyViewHolder.KEY_R1)
        var id5 = intent.getBooleanExtra(MyAdapter.MyViewHolder.KEY_R1_bool, false)
        var id6 = intent.getStringExtra(MyAdapter.MyViewHolder.KEY_R2)
        var id7 = intent.getBooleanExtra(MyAdapter.MyViewHolder.KEY_R2_bool, false)
        var id8 = intent.getStringExtra(MyAdapter.MyViewHolder.KEY_R3)
        var id9 = intent.getBooleanExtra(MyAdapter.MyViewHolder.KEY_R3_bool, false)
        Log.i("BLA", "$id1 & $id2 & $id3 & $id4 & $id5 & $id6 & $id7 & $id8 & $id9")

        binding.id1Q.text = id1
        binding.idCat.text = id2
        binding.idDate.text = id3
        binding.idR1.text = id4
        binding.idB1.isChecked = id5
        binding.idR2.text = id6
        binding.idB2.isChecked = id7
        binding.idR3.text = id8
        binding.idB3.isChecked = id9

    }
}