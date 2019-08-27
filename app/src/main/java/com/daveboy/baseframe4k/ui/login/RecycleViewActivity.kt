package com.daveboy.baseframe4k.ui.login

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.icu.util.TimeUnit
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ScreenUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.daveboy.baseframe4k.R
import com.daveboy.baseframe4k.bean.User
import com.daveboy.core.base.AbstractActivity
import kotlinx.android.synthetic.main.activity_login.*
import androidx.core.content.ContextCompat.getSystemService
import com.blankj.utilcode.util.ConvertUtils
import androidx.core.app.ComponentActivity.ExtraData
import com.blankj.utilcode.util.TimeUtils


class RecycleViewActivity: AbstractActivity() {
    val data= MutableList(20){
        User("$it 张三",20+it)
    }
    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        rv_test.layoutManager=LinearLayoutManager(this)
        rv_test.addItemDecoration(object :RecyclerView.ItemDecoration(){
            val paint= Paint().apply { color= Color.BLUE }
            val paint2= Paint().apply { color= Color.RED }
            val width=ScreenUtils.getScreenWidth()
            val height=ConvertUtils.dp2px(30f)
            override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                super.onDrawOver(c, parent, state)
                val child0 = parent.getChildAt(0)

                //如果第一个item的Bottom<=分割线的高度
                val position=parent.getChildAdapterPosition(child0)
                if (isFirstInGroup(position+1)&&child0.bottom <= height) {
                    //随着RecyclerView滑动 分割线的top=固定为0不动,bottom则赋值为child0的bottom值.
                    c.drawRect(0f, 0f, width.toFloat(), child0.bottom.toFloat(), paint2)
                } else {
                    //固定不动
                    c.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint2)
                }
            }
            override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                super.onDraw(c, parent, state)
                val count = parent.childCount
                for (i in 0 until count) {
                    val view = parent.getChildAt(i)
                    val position=parent.getChildAdapterPosition(view)
                    if(isFirstInGroup(position)) {
                        //分割线不能和item的内容重叠,所以把分割线画在getItemOffsets为item腾出来的位置上.
                        //所以top需要上移item_height
                        val top = view.top - height
                        //bottom同理
                        val bottom = top + height
                        c.drawRect(0f, top.toFloat(), width.toFloat(), bottom.toFloat(), paint)
                    }
                }

            }
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                val position=parent.getChildAdapterPosition(view)
                if(isFirstInGroup(position)) {
                    outRect.top = height
                }
            }
        })
        rv_test.adapter=object:BaseQuickAdapter<User,BaseViewHolder>(R.layout.layout_user,data){
            override fun convert(helper: BaseViewHolder, item: User) {
                helper.setText(R.id.tv_name,item.name)
            }

        }
    }
    fun isFirstInGroup(position:Int):Boolean{
        if(position==0)
            return true

        return data[position-1].age/5!=data[position].age/5
    }
    override fun initListener() {
    }

    override fun initData() {
    }

    override fun initLast() {
    }

}