package com.chenzy.route_lib

/**
 * Created by zhangyu on 2021/11/19.
 */
object RouteManager {

    var routes : HashMap<String,String> = HashMap<String,String>()

    fun gotoPage(path:String){
        routes[path]
    }
}