package com.zyqzyq.lazyorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import android.widget.ArrayAdapter
import android.widget.AdapterView
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
            //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
            val builder = AlertDialog.Builder(this@MenuActivity)
            //    设置Title的图标
            builder.setIcon(R.mipmap.ic_launcher)
            //    设置Title的内容
            builder.setTitle("确认删除该菜吗？")
            //    设置Content来显示一个信息
            builder.setMessage("确定删除吗？")
            //    设置一个PositiveButton
            builder.setPositiveButton("确定") { dialog, which ->
                strs.removeAt(position)
                updateListView() }
            //    设置一个NegativeButton
            builder.setNegativeButton("取消") { dialog, which -> }
            //    设置一个NeutralButton
            builder.show()
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
                strs.add(name)
                dataSave!!.setDataList("string", strs)
                updateListView()
            })
            builder.setNegativeButton("取消", { dialog, which -> })
            builder.show()
            }
        cancel_btn.setOnClickListener {

            //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
            val builder = AlertDialog.Builder(this@MenuActivity)
            //    设置Title的图标
            builder.setIcon(R.mipmap.ic_launcher)
            //    设置Title的内容
            builder.setTitle("弹出警告框")
            //    设置Content来显示一个信息
            builder.setMessage("确认要清空菜单吗？")
            //    设置一个PositiveButton
            builder.setPositiveButton("确定") { dialog, which ->
                strs.clear()
                dataSave!!.emptyDataList()
                updateListView()
                }
            //    设置一个NegativeButton
            builder.setNegativeButton("取消") { dialog, which -> }
            //    设置一个NeutralButton
            builder.show()
        }
    }

    private fun updateListView(){
        menu_list.adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs)
    }
}
