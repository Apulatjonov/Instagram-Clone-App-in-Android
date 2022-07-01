package com.example.instagramclone

import android.view.View

class StoriesItem() {
    var picture:Int? = null
    var name:String? = null
    constructor(picture:Int, name:String):this(){
        this.name = name
        this.picture = picture
    }
}