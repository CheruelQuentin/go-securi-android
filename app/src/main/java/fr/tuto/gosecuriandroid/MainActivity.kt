package fr.tuto.gosecuriandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.net.http.SslError

import android.webkit.SslErrorHandler
import android.webkit.HttpAuthHandler


var name : String? = null
var pass : String? = null

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val extras = intent.extras
        if (extras != null) {
            name = extras.getString("etName")
            pass = extras.getString("etPass")
        }

        webView = findViewById(R.id.webView)
        webView.setWebViewClient(MyClientWebView())
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        webView.loadUrl("https://192.168.1.42/")


    }
    private class MyClientWebView() : WebViewClient(){
        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, er: SslError?) {
            handler.proceed()
            // Ignore SSL certificate errors

        }
        override fun onReceivedHttpAuthRequest(view: WebView?, handler: HttpAuthHandler, host: String?, realm: String? ) {
            handler.proceed(name, pass)
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}

