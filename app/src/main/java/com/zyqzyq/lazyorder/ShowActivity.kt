package com.zyqzyq.lazyorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
    var dataSave: ListDataSave? = null
    var strs = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        order_text.text = ""
        dataSave = ListDataSave(applicationContext, "menu")
        strs.addAll(dataSave!!.getDataList("string"))
        order_ok.setOnClickListener { finish() }
        order_another.setOnClickListener {
            getRandomOrder()
        }
        getRandomOrder()
    }
    private fun getRandomOrder(){
        val builder = AlertDialog.Builder(this@ShowActivity).create()
//        builder.setIcon(R.mipmap.ic_launcher)
//        builder.setTitle("正在随机选择中")
        //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象

        builder.window.setDimAmount(0f);//设置昏暗度为0
        builder.setCanceledOnTouchOutside(false);
        builder.show()
        //    设置我们自己定义的布局文件作为弹出框的Content
        builder.window.setContentView(R.layout.loading)

        Thread(Runnable {
            val num = (Math.random() * strs.size).toInt()
            val other_order_name = strs[num]
            Thread.sleep(1000)
            builder.dismiss()
            order_text.text = other_order_name
        }).start()
    }
}
