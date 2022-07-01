package com.example.instagramclone

class TopPanelSpinnerItem() {
    var name:String? = null
    var pict:Int? = null
    var notifications:String? = null
    constructor(name:String?, pict:Int?, notif:String?):this(){
        this.name = name
        this.pict = pict
        this.notifications = notif
    }
}