package com.chenzy.learnarouter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by zhangyu on 2021/11/30.
 */
class AFragment : Fragment() {
    lateinit var mParentView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mParentView = inflater.inflate(R.layout.fragment_a, container, false)
        return mParentView
    }
}