package com.daveboy.core.util

import android.view.View
import android.widget.EditText

fun EditText.text():String{
    return this.text.toString()
}

fun View.setVisibleOrGone(visible:Boolean){
    visibility=if(visible) View.VISIBLE else View.GONE
}