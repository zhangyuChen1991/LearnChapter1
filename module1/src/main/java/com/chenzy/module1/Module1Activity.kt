package com.chenzy.module1

import android.app.Activity
import android.os.Bundle
import com.chenzy.route.Route

/**
 * Created by zhangyu on 2021/11/19.
 */
@Route(path = "/module1/page")
class Module1Activity :Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}