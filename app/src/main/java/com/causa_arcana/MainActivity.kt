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

        val html = """
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="utf-8"/>
                </head>
                <body>
                    <h1>Hello, World!</h1>
                    <p>This text is rendered with WebView.</p>
                </body>
            </html>
        """.trimIndent()

        val encodedHtml = Base64.encodeToString(html.toByteArray(), Base64.NO_PADDING)

        mainWebView.loadData(encodedHtml, "text/html", "base64")
    }
}
