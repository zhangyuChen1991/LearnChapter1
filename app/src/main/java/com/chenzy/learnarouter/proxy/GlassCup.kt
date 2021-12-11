package com.example.learn.proxy

import android.util.Log

/**
 * 静态代理，直接实现接口
 */
class GlassCup : ProduceCup {
    override fun produce() {
        Log.d(ProduceCup.TAG,"造一个玻璃杯子")
    }

    override fun fillInWater() {
        Log.d(ProduceCup.TAG,"装了一杯水")

    }
}