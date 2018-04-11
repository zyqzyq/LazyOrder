package com.zyqzyq.lazyorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import android.widget.ArrayAdapter
import android.widget.AdapterView
import org.jetbrains.anko.toast
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.input_order.view.*


class MenuActivity : AppCompatActivity() {
    var strs = arrayListOf<String>()
    var dataSave: ListDataSave? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(menu_toolbar)
//        supportActionBar!!.title= "懒人点餐"
        menu_toolbar.setNavigationIcon(R.drawable.back)
        menu_toolbar.setNavigationOnClickListener {
            finish()
        }
        initView()
    }
    private fun initView(){
        dataSave = ListDataSave(applicationContext, "menu")
        strs.addAll(dataSave!!.getDataList("string"))
        menu_list.adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs)
        menu_list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            toast("您点击了第" + position + "个项目" )
        }
        add_btn.setOnClickListener {
            val builder = AlertDialog.Builder(this@MenuActivity)
            builder.setIcon(R.mipmap.ic_launcher)
            builder.setTitle("请输入新增的菜名")
            //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
            val view = LayoutInflater.from(this@MenuActivity).inflate(R.layout.input_order, null)
            //    设置我们自己定义的布局文件作为弹出框的Content
            val new_menu_name = view.menu_name
            builder.setView(view)
            builder.setPositiveButton("确定", { dialog, which ->
                val name = new_menu_name.text.toString()
                //    将输入的用户名和密码打印出来
                strs.add(name)
                dataSave!!.setDataList("string", strs)
                updateListView()
            })
            builder.setNegativeButton("取消", { dialog, which -> })
            builder.show()
            }
        cancel_btn.setOnClickListener {
            strs= arrayListOf()
            updateListView()
        }
    }

    private fun updateListView(){
        menu_list.adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs)
    }
}
