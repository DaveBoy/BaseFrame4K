package com.daveboy.core.ext

sealed class BooleanExt<out T> {

    object Otherwise : BooleanExt<Nothing>()
    class TransferData<T>(val data: T) : BooleanExt<T>()
}
inline fun <T> Boolean.yes(block: () -> T): BooleanExt<T> = when {
    this -> BooleanExt.TransferData(block.invoke())
    else -> BooleanExt.Otherwise
}

inline fun <T> BooleanExt<T>.no(block: () -> T): T = when (this) {
    is BooleanExt.Otherwise -> block.invoke()
    is BooleanExt.TransferData -> this.data
}