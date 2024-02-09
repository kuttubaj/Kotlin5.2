package com.example.kotlin52.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin52.data.models.Item
import com.example.kotlin52.databinding.ItemItemBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var itemLIst = mutableListOf<Item>()

    fun setItem(itemList: MutableList<Item>) {
        this.itemLIst = itemList
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(private val binding: ItemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Item) {
            binding.ivItem.setImageResource(item.image)
            binding.tvItem.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount() = itemLIst.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemLIst[position])
    }
}