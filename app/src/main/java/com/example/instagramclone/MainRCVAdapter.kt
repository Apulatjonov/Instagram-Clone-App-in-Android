package com.example.instagramclone

import android.annotation.SuppressLint
import android.content.Context
import android.view.*
import android.view.animation.*
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.listitemever.view.*


class MainRCVAdapter(var context: Context, var list: MutableList<Post>, var fragmentManager: FragmentManager):RecyclerView.Adapter<MainRCVAdapter.VH>() {
    inner class VH(item: View):RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val item = LayoutInflater.from(context).inflate(R.layout.listitemever, parent, false)

        return VH(item)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VH, position: Int) {
        if (position == 0){
            val stories = Stories()
            holder.itemView.visibility = View.VISIBLE
            fragmentManager.beginTransaction().add(R.id.storyContainer, stories)
                    .show(stories)
                    .commit()
        }else{
            holder.itemView.storyContainer.visibility = View.GONE
        }
        println(list[position].profilePic)
        holder.itemView.secondTopPartOfItemClickedFragment.setBackgroundResource(list[position].profilePic!!)
        holder.itemView.nameOfAuthore.text = list[position].author
        Picasso.get().load(list[position].picture).into(holder.itemView.mainPictOfProfilFotoItemClicked)
        holder.itemView.likedTxtOfProfileFotoClickedItem.text = list[position].likes.toString() + " likes"
        holder.itemView.authorNameOfProfileFotoClickedItem.text = list[position].author
        holder.itemView.textByAuthor.text = list[position].postTxt
        holder.itemView.commenListView.setAdapter(ExpListViewAdapter(context, list[position].comments as MutableList<Post.Comments>))

        holder.itemView.mainPictOfProfilFotoItemClicked.setOnTouchListener(object : View.OnTouchListener {
            private var gt = GestureDetector(object : GestureDetector.SimpleOnGestureListener() {
                override public fun onDoubleTap(e: MotionEvent?): Boolean {
                    if (list[position].liked == true) {
                        list[position].liked = false
                        holder.itemView.likeBtn.setImageResource(R.drawable.likebtn)
                        notifyDataSetChanged()
                    } else {
                        holder.itemView.likeBtn.setImageResource(R.drawable.likedbtn)
                        list[position].liked = true
                        Toast.makeText(context, "Liked!", Toast.LENGTH_SHORT).show()
                        notifyDataSetChanged()
                    }
                    return super.onDoubleTap(e)
                }
            })

            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                gt.onTouchEvent(event)
                return true
            }
        })

        holder.itemView.likeBtn.setOnClickListener{
            if (list[position].liked == true) {
                list[position].liked = false
                holder.itemView.likeBtn.setImageResource(R.drawable.likebtn)
                notifyItemChanged(position)
            } else {
                holder.itemView.likeBtn.setImageResource(R.drawable.likedbtn)
                list[position].liked = true
                Toast.makeText(context, "Liked!", Toast.LENGTH_SHORT).show()
                notifyItemChanged(position)
            }
        }

        holder.itemView.saveBtn.setOnClickListener {
            if (list[position].saved == false){
                list[position].saved = true
                holder.itemView.saveBtn.setImageResource(R.drawable.savedbtn)
                Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()
                notifyItemChanged(position)
            }else{
                holder.itemView.saveBtn.setImageResource(R.drawable.savebtn)
                list[position].saved = false
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}