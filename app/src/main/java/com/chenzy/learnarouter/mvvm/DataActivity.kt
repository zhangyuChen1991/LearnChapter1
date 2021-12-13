package com.chenzy.learnarouter.mvvm

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.chenzy.learnarouter.R
import com.chenzy.learnarouter.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_demo_mvvm.*

/**
 * Created by zhangyu on 2021/12/10.
 */
class DataActivity : AppCompatActivity() {

    lateinit var demoViewModel : DemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_mvvm)

        update_data.setOnClickListener {
            demoViewModel.getDemoData()
        }

        demoViewModel = DemoViewModel()
        demoViewModel.getCurrentData().observe(this, object : Observer<DemoData>{
            override fun onChanged(t: DemoData?) {
                updateUI()
            }
        })

        updateUI()
    }

    fun updateUI(){
        data_tv.text = demoViewModel.getCurrentData().value.toString()
    }
}