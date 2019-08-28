package com.daveboy.baseframe4k.bean

import android.graphics.Path
import android.graphics.PathMeasure

/**
 * path转换成具体的坐标集
 */
class Keyframes {
    private val PRECISION = .5f
    private var mNumPoints = 0
    private var mX: FloatArray? = null
    private var mY: FloatArray? = null
    private var mAngle: FloatArray? = null
    private var mTemp: PosTan? = null
    private var mMaxX: Float = 0f
    private var mMaxY: Float = 0f
    constructor(path:Path){
        initPath(path)
        mTemp= PosTan()
    }

    private fun initPath(path: Path) {
        val pathMeasure=PathMeasure(path,false)
        mX = FloatArray(0)
        mY = FloatArray(0)
        mAngle = FloatArray(0)
        do {
            val length = pathMeasure.length
            val numberPoint=(length/PRECISION+1).toInt()
            val x=FloatArray(numberPoint)
            val y=FloatArray(numberPoint)
            val angle=FloatArray(numberPoint)
            val position=FloatArray(2)
            val tangent=FloatArray(numberPoint)
            for(i in 0 until numberPoint){

            }
        }while (pathMeasure.nextContour())
    }

}