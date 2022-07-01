package com.example.instagramclone

import android.annotation.SuppressLint
import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import kotlinx.android.synthetic.main.commentitem.view.*
import kotlin.random.Random

class ExpListViewAdapter(var context: Context, var list: MutableList<Post.Comments>) : ExpandableListAdapter {
    override fun registerDataSetObserver(observer: DataSetObserver?) {
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
    }

    override fun getGroupCount(): Int = list.size

    override fun getChildrenCount(groupPosition: Int): Int = list.size

    override fun getGroup(groupPosition: Int): Any = list[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int): Any = list[groupPosition]

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun hasStableIds(): Boolean = true

    override fun getGroupView(
            groupPosition: Int,
            isExpanded: Boolean,
            convertView: View?,
            parent: ViewGroup?
    ): View {
        val itemConvert: View
        if (convertView == null) {
            itemConvert = LayoutInflater.from(parent!!.context).inflate(R.layout.commentitem, parent, false)
        } else {
            itemConvert = convertView
        }
        itemConvert.commenterName.text = list[groupPosition].author
        itemConvert.profileFotoCommenter.setImageResource(list[groupPosition].profileFoto!!)
        itemConvert.commentTxt.text = list[groupPosition].text
        itemConvert.timeComment.text = list[groupPosition].time.toString() + " s"
        return itemConvert
    }

    @SuppressLint("SetTextI18n")
    override fun getChildView(
            groupPosition: Int,
            childPosition: Int,
            isLastChild: Boolean,
            convertView: View?,
            parent: ViewGroup?
    ): View {
        val itemConvert: View
        if (convertView == null) {
            itemConvert = LayoutInflater.from(parent!!.context).inflate(R.layout.commentitem, parent, false)
        } else {
            itemConvert = convertView
        }
        itemConvert.commenterName.text = list[groupPosition].author
        itemConvert.profileFotoCommenter.setImageResource(list[groupPosition].profileFoto!!)
        itemConvert.commentTxt.text = list[groupPosition].text
        itemConvert.timeComment.text = "${Random.nextInt(0, 10)} h"
        return itemConvert
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = false

    override fun areAllItemsEnabled(): Boolean = false

    override fun isEmpty(): Boolean = false

    override fun onGroupExpanded(groupPosition: Int) {
    }

    override fun onGroupCollapsed(groupPosition: Int) {
    }

    override fun getCombinedChildId(groupId: Long, childId: Long): Long = groupId.toLong()

    override fun getCombinedGroupId(groupId: Long): Long {
        return groupId.toLong()
    }
}