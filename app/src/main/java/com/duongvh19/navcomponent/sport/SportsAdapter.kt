package com.duongvh19.navcomponent.sport

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.duongvh19.navcomponent.model.Sport
import com.duongvh19.navcomponent.databinding.ItemSportBinding

class SportsAdapter(private val onClickItem : (Sport) -> Unit) :
    ListAdapter<Sport, SportsAdapter.SportViewHolder> (DiffCallback){

    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        context = parent.context
        val binding = ItemSportBinding.inflate(LayoutInflater.from(context),
        parent, false)
        return SportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.itemView.setOnClickListener{
            onClickItem(currentItem)
        }
        holder.bindItem(currentItem, context)
    }

    class SportViewHolder(private val binding: ItemSportBinding)
        : ViewHolder(binding.root) {

            fun bindItem(sport : Sport, context : Context) {
                binding.title.text = context.getString(sport.titleResourceId)
                binding.sportsImage.setImageResource(sport.imageResourceId)
            }
        }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Sport> () {
            override fun areItemsTheSame(oldItem: Sport, newItem: Sport): Boolean {
                return  oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Sport, newItem: Sport): Boolean {
                return oldItem == newItem
            }

        }
    }

}