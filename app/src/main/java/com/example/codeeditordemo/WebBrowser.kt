package com.example.codeeditordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_web_browser.*

class WebBrowser : AppCompatActivity() {
    lateinit var webView:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_browser)
        webView = findViewById(R.id.web_view)

        webView.loadData(intent.getStringExtra("code").toString(),"text/html; charset=utf-8",null)

    }
}