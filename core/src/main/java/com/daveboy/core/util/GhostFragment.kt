package com.daveboy.core.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * 你只是个工具人
 * @property requestCode Int
 * @property intent Intent?
 * @property callback Function1<[@kotlin.ParameterName] Intent?, Unit>?
 */
class GhostFragment : Fragment() {

    private var requestCode = -1
    private var intent: Intent? = null
    private var callback: ((result: Intent?) -> Unit)? = null

    fun init(requestCode: Int, intent: Intent, callback: ((result: Intent?) -> Unit)) {
        this.requestCode = requestCode
        this.intent = intent
        this.callback = callback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 当设备旋转时,fragment不会随托管activity一起销毁并重建
         */
        retainInstance = true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        intent?.let { startActivityForResult(it, requestCode) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == this.requestCode) {
            val result = if (resultCode == Activity.RESULT_OK && data != null) data else null
            callback?.let { it(result) }
        }
    }

    override fun onDetach() {
        super.onDetach()
        intent = null
        callback = null
    }
}
