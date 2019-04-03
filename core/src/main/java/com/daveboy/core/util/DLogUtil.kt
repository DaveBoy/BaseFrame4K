package com.daveboy.core.util

import android.util.Log

/**
 * 日志类
 */
class DLogUtil {
    companion object {
        var TAG = "DLogUtil"
        var loggEnable = true
        fun i(msg: String, tag: String = TAG) {
            if (loggEnable)
                Log.i(tag, msg)
        }

        fun w(msg: String, tag: String = TAG) {
            if (loggEnable)
                Log.w(tag, msg)
        }

        fun e(msg: String, t: Throwable? = null, tag: String = TAG) {
            if (loggEnable)
                Log.e(tag, msg, t)
        }

        fun d(msg: String, tag: String = TAG) {
            if (loggEnable)
                Log.d(tag, msg)
        }
    }
}