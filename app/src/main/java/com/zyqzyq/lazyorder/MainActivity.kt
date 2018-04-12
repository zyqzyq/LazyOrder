package com.zyqzyq.lazyorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import android.content.Intent
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
    fun randomOrder(){
        val num = (Math.random() * strs.size).toInt()
        val order_name = strs[num]
        //携带数据
        val intent = Intent(this@MainActivity, ShowActivity::class.java)
        val bundle = Bundle()
        bundle.putString("name", order_name)
        //把附加的数据放到意图当中
        intent.putExtras(bundle)
        //执行意图
        startActivity(intent)
    }
    override fun onResume() {
        super.onResume()
        strs.clear()
        strs.addAll(dataSave!!.getDataList("string"))
    }
}
