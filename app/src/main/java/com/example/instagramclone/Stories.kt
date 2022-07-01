package com.example.instagramclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_stories.view.*

class Stories : Fragment() {
    lateinit var root:View
    lateinit var list:MutableList<StoriesItem>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_stories, container, false)

        loadList()

        root.storiesRCV.adapter = StoriesRCVAdapter(root.context, list)

        return root
    }

    private fun loadList() {
        list = mutableListOf()
        list.addAll(mutableListOf(StoriesItem(R.drawable.addstory, "apulatjonov"), StoriesItem(R.drawable.michael, "Michael Jackson"), StoriesItem(R.drawable.jacksparrow, "Jack Sparrow"), StoriesItem(R.drawable.grindelwald, "Grindelwald"), StoriesItem(R.drawable.pastelpaladin, "Panic at the Disco"), StoriesItem(R.drawable.leo, "Leo Messi"), StoriesItem(R.drawable.ronaldo, "Ronaldo"), StoriesItem(R.drawable.davyjones, "Davy Jones"), StoriesItem(R.drawable.dog, "Dog")))
    }
}