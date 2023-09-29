package com.example.taskmanager_month4.ui

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url : String?){
    Glide.with(this).load(url).into(this)
}