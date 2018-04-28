package com.zyqzyq.lazyorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import kotlinx.android.synthetic.main.activity_web.*



class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        webView.loadUrl("file:///android_asset/web/index.html")
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true// 打开本地缓存提供JS调用,至关重要
        webView.settings.setAppCacheMaxSize((1024 * 1024 * 8).toLong())// 实现8倍缓存
        webView.settings.allowFileAccess = true
        webView.settings.setAppCacheEnabled(true)
        val appCachePath = application.cacheDir.absolutePath
        webView.settings.setAppCachePath(appCachePath)
        webView.settings.databaseEnabled = true

//设置自适应屏幕，两者合用
        webView.settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webView.settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

//缩放操作
        webView.settings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webView.settings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webView.settings.setDisplayZoomControls(false); //隐藏原生的缩放控件

//其他细节操作
        webView.settings.setAllowFileAccess(true); //设置可以访问文件
        webView.settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webView.settings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webView.settings.setDefaultTextEncodingName("utf-8");//设置编码格式
    }

    //点击返回上一页面而不是退出浏览器
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
