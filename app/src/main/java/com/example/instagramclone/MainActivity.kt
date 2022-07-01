package com.example.instagramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toppanelspinneritem.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var topPanelFirst:TopPanelFirst
    lateinit var profileFragment:ProfileFragment
    lateinit var downHostFragment:DownHostFragment

    lateinit var stories: Stories
    lateinit var fragmentFirst:HomeFirstTop
    lateinit var mainFragment: MainFragment
    var mainLoaded by Delegates.notNull<Boolean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentFirst = HomeFirstTop()
        stories = Stories()
        mainFragment = MainFragment()

        topPanelFirst = TopPanelFirst()
        profileFragment = ProfileFragment()
        downHostFragment = DownHostFragment()

        firstLoad()

        homeBtn.setOnClickListener{
            enterHomeFragment.setImageResource(R.drawable.homeclickedbtn)
            loadHome()
        }
        profileBtn.setOnClickListener {
            enterHomeFragment.setImageResource(R.drawable.homebtn)
            loadProfile()
        }
        enterHomeFragment.setOnClickListener{
            enterHomeFragment.setImageResource(R.drawable.homeclickedbtn)
            loadHome()
        }
        enterProfileFragment.setOnClickListener {
            enterHomeFragment.setImageResource(R.drawable.homebtn)
            loadProfile()
        }
    }

    private fun loadHome() {
        supportFragmentManager.beginTransaction().replace(toolbarContainer.id, fragmentFirst)
                .commit()
//        supportFragmentManager.beginTransaction().replace(R.id.profileFragmentContainer, stories)
//                .commit()
        supportFragmentManager.beginTransaction().remove(profileFragment).commit()
        supportFragmentManager.beginTransaction()
                .replace(R.id.fotosContainer, mainFragment).commit()
    }


    private fun loadProfile() {
            supportFragmentManager.beginTransaction()
                .show(topPanelFirst)
                .replace(R.id.toolbarContainer, topPanelFirst).commit()
            supportFragmentManager.beginTransaction()
                .show(profileFragment)
                .add(R.id.profileFragmentContainer, profileFragment).commit()
            supportFragmentManager.beginTransaction()
                .show(downHostFragment)
                .replace(R.id.fotosContainer, downHostFragment).commit()
    }
     private fun firstLoad(){
         supportFragmentManager.beginTransaction().add(R.id.toolbarContainer ,topPanelFirst).commit()
         supportFragmentManager.beginTransaction().add(R.id.profileFragmentContainer, profileFragment).commit()
         supportFragmentManager.beginTransaction().add(R.id.fotosContainer, downHostFragment).commit()
     }
}