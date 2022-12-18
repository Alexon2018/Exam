package com.example.exam.ViewModels

import androidx.lifecycle.ViewModel
import com.example.exam.dataclasses.MyItem
import com.example.exam.dataclasses.Response

class mainViewModel : ViewModel() {

    val filteredArray = ArrayList<MyItem>()

////mock data
    var temp = MyItem(
        "Care vehicul va trece ultimul prin intersectie?",
        Response("Tramvaiul", false),
        Response("Ambulanta cu semnalalele luminoase si sonore pornite", false),
        Response("BMW-ul cu numere de Bulgaria", true),
        "Categoria intai",
        "23-12-2022"
    )
////end of mock data

    fun getData() : List<MyItem>{
        filteredArray.clear()
        filteredArray+=temp
        return filteredArray
    }

    init {
        getData()
    }

}