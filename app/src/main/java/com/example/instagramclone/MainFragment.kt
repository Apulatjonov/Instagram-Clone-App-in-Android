package com.example.instagramclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {
    lateinit var root:View
    lateinit var list:MutableList<Post>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_main, container, false)
        loadPosts()
        root.mainRCVEver.adapter = MainRCVAdapter(root.context, list, requireFragmentManager())
        root.mainRCVEver.addOnScrollListener(object : RecyclerView.OnScrollListener(){

        })

        return root
    }

    private fun loadPosts() {
        list = mutableListOf()
        list.addAll(listOf(Post("https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Michael_Jackson_Dangerous_World_Tour_1993.jpg/1200px-Michael_Jackson_Dangerous_World_Tour_1993.jpg", 959, mutableListOf(Post().Comments("Davy Jones", "The best singer ever!", R.drawable.davyjones, 10)), "Legend!", false, false, R.drawable.michael, "Michael Jackson"), Post("https://upload.wikimedia.org/wikipedia/commons/7/7b/BlackPearl.jpg", 552, mutableListOf(Post().Comments("Michael Jackson", "Why you need that ship?", R.drawable.michael, 15)), "My beloved ship!", false, false, profilePic = R.drawable.jacksparrow, "Jack Sparrow"), Post("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2016%2F11%2Fdepp-2000.jpg&q=85", 1998, mutableListOf(Post().Comments("Jack Sparrow", "I have my compass!", R.drawable.jacksparrow, 59)), "You think you can hold me?", false, false, R.drawable.grindelwald, "Grindelwald"), Post("https://images.8tracks.com/cover/i/009/651/481/tumblr_nwy2ivxZqy1uok2fgo1_500-2429.jpg?rect=37,0,442,442&q=98&fm=jpg&fit=max", 596, mutableListOf(Post().Comments("Ronaldo", "Crown is mine, always", R.drawable.ronaldo, 35)), "Taking back the crown!", false, false, R.drawable.pastelpaladin, "Panic at the disco"), Post("https://i.guim.co.uk/img/media/31fd0df59c553c6615364b505eced01fa453ae0c/0_114_4000_2400/master/4000.jpg?width=445&quality=45&auto=format&fit=max&dpr=2&s=2c6bcc1f335804a7f76a632de397be04", 966, mutableListOf(Post().Comments("Ronaldo", "Xaxaxaxaxaxaxaxa", R.drawable.ronaldo, 16)), "Good Bye Barcelona!", false, false, R.drawable.leo, "Leo Messi"), Post("https://images.unsplash.com/photo-1543466835-00a7907e9de1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8&w=1000&q=80", 1111, mutableListOf(), "Don't worry, Be happy!", false, false, R.drawable.dog, "Dog")))
    }
}