package com.daveboy.baseframe4k

import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.daveboy.baseframe4k.api.service
import com.daveboy.core.util.DSPUtil
import com.daveboy.http.base.BaseObserver
import com.daveboy.http.core.RetrofitManager
import com.daveboy.http.util.handleResult
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDrawable()
        initListener()
    }

    private fun initListener() {
        login.setOnClickListener {
            var userName=username_inputly.editText!!.text.toString()
            var password=password_inputly.editText!!.text.toString()
            RetrofitManager.service
                .login(userName,password)
                .compose(handleResult(this.bindUntilEvent(ActivityEvent.DESTROY)))
                .subscribe(object :BaseObserver<Any>(){
                    override fun onFinal(t: Any?, error: Throwable?) {
                        t?.also{
                            ToastUtils.showShort("登录成功")
                        }
                    }

                })

        }
    }

    private fun initDrawable() {
        var drawable= resources.getDrawable(R.mipmap.user)
        drawable.setBounds(0,0,100,100)
        username_inputly.editText!!.setCompoundDrawables(drawable,null,null,null)

        drawable= resources.getDrawable(R.mipmap.password)
        drawable.setBounds(0,0,100,100)
        password_inputly.editText!!.setCompoundDrawables(drawable,null,null,null)
    }
}
