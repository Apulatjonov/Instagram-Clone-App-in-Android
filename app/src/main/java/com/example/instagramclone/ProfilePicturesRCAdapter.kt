package com.example.instagramclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.profilepicturescontaineritem.view.*

@Suppress("DEPRECATION")
class ProfilePicturesRCAdapter(var context: Context, var list: MutableList<Post>, var fragmentManager: FragmentManager) : RecyclerView.Adapter<ProfilePicturesRCAdapter.VH>() {
    inner class VH(item: View) : RecyclerView.ViewHolder(item), View.OnClickListener {
        override fun onClick(v: View?) {
            val fragment = ProfileFotoListItemClickedFragment()
            val topPanelFirst = TopPanelFirst()
            val profileFragment = ProfileFragment()
            val downHostFragment = DownHostFragment()
            fragmentManager.beginTransaction().hide(topPanelFirst).commit()
            fragmentManager.beginTransaction().hide(profileFragment).commit()
            fragmentManager.beginTransaction().hide(downHostFragment).commit()
            fragmentManager.beginTransaction().add(R.id.toolbarContainer, fragment).commit()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val item = LayoutInflater.from(context).inflate(R.layout.profilepicturescontaineritem, parent, false)
        return VH(item)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Picasso.get().load(list[position].picture).into(holder.itemView.pictureProfilePictureHolderItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}