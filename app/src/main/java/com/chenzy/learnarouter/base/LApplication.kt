package com.chenzy.learnarouter.base

import android.app.Application
import android.content.Context

/**
 * Created by zhangyu on 2021/12/13.
 */
class LApplication : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}