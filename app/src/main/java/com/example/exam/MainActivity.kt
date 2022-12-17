package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam.databinding.ActivityMainBinding
import com.example.exam.dataclasses.MyItem
import com.example.exam.dataclasses.Response
import com.example.exam.utils.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout

//suport pentru UP button
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

////mock data
//        filteredArray.clear()
//        var temp = MyItem(
//            "Care vehicul va trece ultimul prin intersectie?",
//            Response("Tramvaiul", false),
//            Response("Ambulanta cu semnalalele luminoase si sonore pornite", false),
//            Response("BMW-ul cu numere de Bulgaria", true),
//            "Categoria intai",
//            "23-12-2022"
//        )
//        filteredArray+=temp
////end of mock data

//        binding.rv.layoutManager = LinearLayoutManager(this)
//        binding.rv.adapter= MyAdapter(filteredArray)
//        binding.rv.hasFixedSize()
//
//        binding.fab.setOnClickListener {
//            val intent = Intent(this, DetailActivity::class.java)
//            startActivity(intent)
//        }

    }

    //tot pentru UP button
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }


}