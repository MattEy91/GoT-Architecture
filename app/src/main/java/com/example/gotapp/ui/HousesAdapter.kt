package com.example.gotapp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gotapp.databinding.ViewHouseItemBinding
import com.example.gotapp.domain.model.House
import com.example.gotapp.ui.DetailActivity.Companion.EXTRA_HOUSE

class HousesAdapter : ListAdapter<House, HousesAdapter.HouseItemViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<House>() {
        override fun areItemsTheSame(oldItem: House, newItem: House): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: House, newItem: House): Boolean {
            return false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHouseItemBinding.inflate(layoutInflater)

        return HouseItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HouseItemViewHolder, position: Int) {
        val currentHouse = getItem(position)
        holder.binding.house = currentHouse
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java).apply {
                putExtra(EXTRA_HOUSE, currentHouse)
            }
            it.context.startActivity(intent)
        }
    }

    inner class HouseItemViewHolder(val binding: ViewHouseItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}