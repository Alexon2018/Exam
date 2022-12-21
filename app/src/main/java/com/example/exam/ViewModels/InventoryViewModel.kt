package com.example.exam.ViewModels

import androidx.lifecycle.*
import com.example.exam.model.Item
import com.example.exam.model.ItemDao
import kotlinx.coroutines.launch

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {

    val allItems: LiveData<List<Item>> = itemDao.getItems().asLiveData()

    // aici pregatim o corutina pentru insert, folosind DAO
    private fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.insert(item)
        }
    }

    //aici pregatim corutina pentru update folosind DAO
    private fun updateItem(item: Item) {
        viewModelScope.launch {
            itemDao.update(item)
        }
    }

    //aici pregatim corutina pentru delete folosind DAO
    fun deleteItem(item: Item) {
        viewModelScope.launch {
            itemDao.delete(item)
        }
    }

    //aici pregatim un nou entry, cu parametrii necesari, si intoarcem un obiect de tip model/Item
    private fun getNewItemEntry(itemName: String, itemRaspuns1: String, itemRaspuns2: String): Item {
        return Item(
            itemIntrebare = itemName,
            itemRaspuns1 = itemRaspuns1,
            itemRaspuns2 = itemRaspuns2
        )
    }

    // aici construim functia de add, luam parametrii cu getNew si apoi apelam insert/corutina
    fun addNewItem(itemName: String, itemRaspuns1: String, itemRaspuns2: String ) {
        val newItem = getNewItemEntry(itemName, itemRaspuns1, itemRaspuns2)
        insertItem(newItem)
    }

    //aici verificam daca sunt completate campurile din formular
    fun isEntryValid(itemName: String, itemRaspuns1: String, itemRaspuns2: String): Boolean {
        if (itemName.isBlank() || itemRaspuns1.isBlank() || itemRaspuns2.isBlank()) {
            return false
        }
        return true
    }

    //aici facem getItem/DAO si folosim LiveData
    fun retrieveItem(id: Int): LiveData<Item> {
        return itemDao.getItem(id).asLiveData()
    }

    // aici intoarcem un obiect de tip Item, pentru update
    private fun getUpdatedItemEntry(
        itemId: Int,
        itemName: String,
        itemRaspuns1: String,
        itemRaspuns2: String
    ): Item {
        return Item(
            id = itemId,
            itemIntrebare = itemName,
            itemRaspuns1 = itemRaspuns1,
            itemRaspuns2 = itemRaspuns2
        )
    }

    // aici facem update pe Item, ii dam parametrii, apelam updatedItem de mai sus, si apoi lansam corutina de update/DAO
    fun updateItem(
        itemId: Int,
        itemName: String,
        itemRaspuns1 : String,
        itemRaspuns2 : String
    ) {
        val updatedItem = getUpdatedItemEntry(itemId, itemName, itemRaspuns1, itemRaspuns2)
        updateItem(updatedItem)
    }

}
class InventoryViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

