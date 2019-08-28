package com.daveboy.baseframe4k.bean

import android.graphics.PointF

/**
 * 坐标点
 * @property fraction Float 所处进度
 * @property index Int 所处下标
 * @property angle Float 倾斜角度
 * @constructor
 */
class PosTan(val fraction:Float=0f,val index:Int=0,val angle:Float=0f,x:Float=0f,y:Float=0f):PointF(x,y){
    override fun equals(other: Any?): Boolean {
        return other is PosTan && index==other.index
    }
}