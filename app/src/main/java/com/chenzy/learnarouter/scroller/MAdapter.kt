package com.chenzy.learnarouter.scroller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chenzy.learnarouter.R
import com.chenzy.learnarouter.utils.ToastUtils
import kotlinx.android.synthetic.main.m_list.view.*

/**
 * Created by zhangyu on 2021/12/17.
 */
class MAdapter : RecyclerView.Adapter<MAdapter.MViewHolder>() {

    inner class MViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        init {
            itemView.tv.setOnClickListener {
                ToastUtils.showShort("click $adapterPosition")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.m_list,parent,false))
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.itemView.tv.text = "$position"
    }

    override fun getItemCount(): Int {
        return 100
    }
}