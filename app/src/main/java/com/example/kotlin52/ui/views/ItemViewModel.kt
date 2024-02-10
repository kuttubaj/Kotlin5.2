package com.example.kotlin52.ui.views
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin52.data.models.Item
import com.example.kotlin52.data.repository.ItemRepository
import com.example.kotlin52.utils.UiState

class ItemViewModel : ViewModel() {
    private val _itemLiveData = MutableLiveData<UiState<List<Item>>>()
    val itemLIveData: LiveData<UiState<List<Item>>> = _itemLiveData
    private val itemRepository = ItemRepository()

    init {
        getItem()
    }

    fun getItem() {
        _itemLiveData.value = UiState(isLoading = false, success =  itemRepository.getItem())
        Log.e("data", "getHeroes: ${itemRepository.getItem()}", )
    }

    fun addItem(item: Item) {
        itemRepository.addItem(item)
    }

    override fun onCleared() {
        super.onCleared()
    }
}