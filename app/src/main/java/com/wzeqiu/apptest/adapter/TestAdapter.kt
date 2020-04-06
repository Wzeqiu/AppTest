package com.wzeqiu.apptest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wzeqiu.apptest.R
import com.wzeqiu.apptest.bean.QuarterBean

class TestAdapter(private val context: Context, private val data: List<Pair<String, QuarterBean>>) :
    RecyclerView.Adapter<TestAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.test_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        var quarterBean = data[position].second

        holder.text.setText(data[position].first + "年\n 总：" + quarterBean.total.toString())


        if (quarterBean.decline) {
            holder.click.visibility = View.VISIBLE
        } else {
            holder.click.visibility = View.GONE
        }


        holder.click.setOnClickListener {
            println("数据下降")
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text: TextView = itemView.findViewById(R.id.tv_total)
        var click: TextView = itemView.findViewById(R.id.tv_click)
    }


}