package com.chenzy.route

/**
 * Created by zhangyu on 2021/11/18.
 */
@Retention(value = AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Route(val path: String)