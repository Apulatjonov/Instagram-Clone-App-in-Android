package com.example.instagramclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_top_panel_first.view.*

class TopPanelFirst : Fragment() {
    lateinit var root:View
    lateinit var list:MutableList<TopPanelSpinnerItem>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_top_panel_first, container, false)
        loadData()
        root.topPanelFirstSpinner.adapter = TopPanelSpinnerAdapter(root.context, list)

        return root
    }

    private fun loadData() {
        list = mutableListOf()
        list.add(TopPanelSpinnerItem("Apulatjonov", R.drawable.pict, "15 notifications"))
    }

}