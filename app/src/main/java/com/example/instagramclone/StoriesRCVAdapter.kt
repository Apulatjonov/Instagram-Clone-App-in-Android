package com.example.instagramclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.storyitem.view.*

class StoriesRCVAdapter(var context: Context, var list:MutableList<StoriesItem>):RecyclerView.Adapter<StoriesRCVAdapter.VH>() {
    inner class VH(item:View):RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val item = LayoutInflater.from(context).inflate(R.layout.storyitem, parent, false)
        return VH(item)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.storyItemTxt.text = list[position].name
        holder.itemView.StoryItemImage.setImageResource(list[position].picture!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}