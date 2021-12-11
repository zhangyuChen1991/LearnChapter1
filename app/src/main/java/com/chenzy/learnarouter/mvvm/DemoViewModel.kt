package com.chenzy.learnarouter.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by zhangyu on 2021/12/10.
 */
class DemoViewModel : ViewModel() {
    var data: MutableLiveData<DemoData>? = null
    fun getCurrentData(): MutableLiveData<DemoData> {
        if (data == null) {
            data = MutableLiveData<DemoData>();
        }
        return data!!
    }
}