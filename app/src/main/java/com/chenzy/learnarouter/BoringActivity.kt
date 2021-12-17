package com.chenzy.learnarouter

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.chenzy.learnarouter.constant.Constants
import com.chenzy.learnarouter.scroller.MAdapter
import com.chenzy.learnarouter.utils.SizeUtils
import com.chenzy.learnarouter.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_boring.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by zhangyu on 2021/11/30.
 */
class BoringActivity : AppCompatActivity() {
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boring)
        ToastUtils.showShort("BoringActivity")

        rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcv.adapter = MAdapter()

        MainScope().launch {
            //Dispatchers.Main作为默认调度器
            repeat(30) {
                delay(2000)
                rcv.smoothScrollBy(0,SizeUtils.dp2px(60f),null,1000)
            }
        }
    }
}