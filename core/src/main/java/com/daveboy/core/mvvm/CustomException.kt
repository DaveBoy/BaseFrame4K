package com.daveboy.core.mvvm

import com.daveboy.core.util.errorCast

class CustomException : Exception {
    var errorMsg: String

    constructor(error: String?) : super(error) {
        errorMsg = error?:"no message"
    }

    constructor(throwable: Throwable?) : super(throwable) {
        errorMsg = parseError(throwable)
    }

    private fun parseError(throwable: Throwable?): String {
        return throwable.errorCast()
    }
}