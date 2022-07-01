package com.example.instagramclone

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile_foto_list_item_clicked.view.*
import kotlinx.android.synthetic.main.listitemever.view.*
import java.io.Serializable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
@SuppressLint("StaticFieldLeak")
lateinit var root:View
lateinit var item:Post

class ProfileFotoListItemClickedFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Serializable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable("data") as Post
            item = param1 as Post
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_profile_foto_list_item_clicked, container, false)
        Picasso.get().load(item.picture).into(root.mainPictOfProfilFotoItemClicked)

        return root
    }
}