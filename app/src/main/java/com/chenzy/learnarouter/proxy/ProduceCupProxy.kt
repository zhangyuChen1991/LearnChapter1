package com.example.learn.proxy

import android.util.Log
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * 这里通过动态代理的方式实现ProduceCup接口
 */
class ProduceCupProxy {
    fun p(){
        val handler: InvocationHandler = InvocationHandler { proxy, method, args ->
            Log.d(ProduceCup.TAG,method.name)
            if (method.name.equals("produce")) {
                Log.d(ProduceCup.TAG,"动态代理，制造了一个杯子")
            }else if(method.name.equals("fillInWater")){
                Log.d(ProduceCup.TAG,"动态代理，在杯子里装了一杯水")
            }
            null
        }
        val hello: ProduceCup = Proxy.newProxyInstance(
            ProduceCup::class.java.classLoader, arrayOf<Class<*>>(ProduceCup::class.java),  // 传入要实现的接口
            handler
        ) as ProduceCup // 传入处理调用方法的InvocationHandler

        hello.produce()
        hello.fillInWater()
    }
}