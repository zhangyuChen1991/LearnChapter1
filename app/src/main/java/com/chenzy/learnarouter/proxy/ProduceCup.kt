package com.example.learn.proxy

interface ProduceCup {
    companion object{
        val TAG = "LEARN_PROXY"
    }
    fun produce()
    fun fillInWater()


}