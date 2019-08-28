package com.daveboy.baseframe4k.ui.login

import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.daveboy.baseframe4k.R
import com.daveboy.baseframe4k.bean.User
import com.daveboy.core.base.AbstractActivity
import kotlinx.android.synthetic.main.activity_login.*


class RecycleView1Activity: AbstractActivity() {
    val data= MutableList(20){
        User("$it 张三",20+it)
    }
    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        rv_test.layoutManager=LinearLayoutManager(this)
        rv_test.adapter=object:BaseQuickAdapter<User,BaseViewHolder>(R.layout.layout_user,data){
            override fun convert(helper: BaseViewHolder, item: User) {
                helper.setText(R.id.tv_name,item.name)
            }

        }
    }

    override fun initListener() {
    }

    override fun initData() {
    }

    override fun initLast() {
    }

}