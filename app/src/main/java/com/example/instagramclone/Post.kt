package com.example.instagramclone

import java.io.Serializable

class Post(): Serializable {
    var picture:String? = null
    var likes:Int? = null
    var comments:MutableList<Comments>? = null
    var postTxt:String? = null
    var liked:Boolean? = null
    var saved:Boolean? = null
    var profilePic:Int? = null
    var author:String? = null
    constructor(picture:String, likes:Int, comments:MutableList<Comments>, postTxt:String, liked:Boolean, saved:Boolean, profilePic:Int, autjor:String):this(){
        this.picture = picture
        this.likes = likes
        this.comments = comments
        this.postTxt = postTxt
        this.liked = liked
        this.saved = saved
        this.profilePic = profilePic
        this.author = autjor
    }
    constructor(picture:String, likes:Int, comments:MutableList<Comments>, postTxt:String, liked:Boolean, saved:Boolean):this(){
        this.picture = picture
        this.likes = likes
        this.comments = comments
        this.postTxt = postTxt
        this.liked = liked
        this.saved = saved
    }

    inner class Comments(){
        var author:String? = null
        var text:String? = null
        var profileFoto:Int? = null
        var time:Int? = null
        constructor(author:String, text:String, profileFoto:Int, time:Int):this(){
            this.author = author
            this.text = text
            this.profileFoto = profileFoto
            this.time = time
        }
        constructor(author:String, text:String):this(){
            this.author = author
            this.text = text
        }
    }
}