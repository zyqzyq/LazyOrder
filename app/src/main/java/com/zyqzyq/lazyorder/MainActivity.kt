package com.zyqzyq.lazyorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {
    var dataSave: ListDataSave? = null
    var strs = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        dataSave = ListDataSave(applicationContext, "menu")
//        supportActionBar!!.title= "懒人点餐"
        toolbar.setNavigationIcon(R.drawable.menu)
        toolbar.setNavigationOnClickListener {
            startActivity<MenuActivity>()
        }
        strs.addAll(dataSave!!.getDataList("string"))
        start_order.setOnClickListener {
            if (strs.isNotEmpty()){
                randomOrder()
            }
            else{
                toast("请提前添加菜单内容。")
            }
        }
    }
    private fun randomOrder(){
        startActivity<ShowActivity>()
    }
    override fun onResume() {
        super.onResume()
        strs.clear()
        strs.addAll(dataSave!!.getDataList("string"))
    }
}
