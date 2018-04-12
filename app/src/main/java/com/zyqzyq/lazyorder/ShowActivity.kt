package com.zyqzyq.lazyorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
    var dataSave: ListDataSave? = null
    var strs = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        val order_name = this.intent.extras.get("name")
        order_text.text = order_name.toString()
        dataSave = ListDataSave(applicationContext, "menu")
        strs.addAll(dataSave!!.getDataList("string"))
        order_ok.setOnClickListener { finish() }
        order_another.setOnClickListener {
            val num = (Math.random() * strs.size).toInt()
            val other_order_name = strs[num]
            order_text.text = other_order_name
        }
    }
}
