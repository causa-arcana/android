package com.causa_arcana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainWebView: WebView = findViewById(R.id.mainWebView)

        val htmlGenerator = HtmlGenerator("""
        <h1>Hello, World!</h1>
        <p>This text is rendered with WebView.</p>
        """)

        val fullHtml = htmlGenerator.fullHtml()
        val encodedFullHtml = Base64.encodeToString(fullHtml.toByteArray(), Base64.NO_PADDING)

        mainWebView.loadData(encodedFullHtml, "text/html", "base64")
    }
}
