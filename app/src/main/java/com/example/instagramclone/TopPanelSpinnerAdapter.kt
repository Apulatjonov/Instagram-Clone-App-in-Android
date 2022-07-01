package com.example.instagramclone

import android.content.Context
import android.database.DataSetObserver
import android.os.Build
import android.text.Layout
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SpinnerAdapter
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.toppanelspinneritem.view.*

class TopPanelSpinnerAdapter(var context:Context, var list:MutableList<TopPanelSpinnerItem>):SpinnerAdapter {
    override fun registerDataSetObserver(observer: DataSetObserver?) {
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean = true

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val convertItem: View
        if (convertView == null){
            convertItem = LayoutInflater.from(context).inflate(R.layout.toppanelspinneritem, parent, false)
        }else{
            convertItem = convertView
        }
        convertItem.toppanelfirstitemname.text = list[position].name.toString()
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, 0, 0)
        convertItem.toppanelfirstitemname.layoutParams = params
        convertItem.toppanelfirstitemname.layoutParams = params
        convertItem.toppanelfirstspinneritemimage.setImageResource(R.drawable.lock)
        convertItem.toppanelfirstspinneritemimage.layoutParams.width = 30
        convertItem.toppanelfirstspinneritemimage.layoutParams.height = 30
        convertItem.toppanelfirstitemnotifications.visibility = View.GONE
        return convertItem
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getViewTypeCount(): Int {
        return list.size
    }

    override fun isEmpty(): Boolean = false

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val convertItem: View
        if (convertView == null){
            convertItem = LayoutInflater.from(context).inflate(R.layout.toppanelspinneritem, parent, false)
        }else{
            convertItem = convertView
        }
        convertItem.toppanelfirstitemname.text = list[position].name
        convertItem.toppanelfirstspinneritemimage.setImageResource(list[position].pict!!)
        convertItem.toppanelfirstitemnotifications.text = list[position].notifications
        convertItem.SpinnerArrotItemEver.visibility = View.GONE
        convertItem.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return convertItem
    }
}