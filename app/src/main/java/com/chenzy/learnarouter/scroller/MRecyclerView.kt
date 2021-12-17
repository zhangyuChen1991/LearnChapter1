package com.chenzy.learnarouter.scroller

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by zhangyu on 2021/12/17.
 */
class MRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {
    override fun onTouchEvent(e: MotionEvent?): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        return false
    }
}