package com.zyqzyq.lazyorder

import android.text.method.TextKeyListener.clear
import android.R.id.edit
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by pc on 2018/4/11.
 */
class ListDataSave(mContext: Context, preferenceName: String) {
    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        preferences = mContext.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
        editor = preferences.edit()
    }

    /**
     * 保存List
     * @param tag
     * @param datalist
     */
    fun <T> setDataList(tag: String, datalist: List<T>?) {
        if (null == datalist || datalist.size <= 0)
            return

        val gson = Gson()
        //转换成json数据，再保存
        val strJson = gson.toJson(datalist)
        editor.clear()
        editor.putString(tag, strJson)
        editor.commit()

    }

    /**
     * 获取List
     * @param tag
     * @return
     */
    fun <T> getDataList(tag: String): List<T> {
        var datalist: List<T> = ArrayList()
        val strJson = preferences.getString(tag, null) ?: return datalist
        val gson = Gson()
        datalist = gson.fromJson(strJson, object : TypeToken<List<T>>() {

        }.type)
        return datalist

    }
}