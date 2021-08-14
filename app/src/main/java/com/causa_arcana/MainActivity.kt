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

        val contentHtml = """
        <h1>Hello, World!</h1>
        <p>This text is rendered with WebView.</p>
        """

        val fullHtml = fullHtml(contentHtml)
        val encodedFullHtml = Base64.encodeToString(fullHtml.toByteArray(), Base64.NO_PADDING)

        mainWebView.loadData(encodedFullHtml, "text/html", "base64")
    }

    private fun fullHtml(contentHtml: String): String {
        return """
        <!DOCTYPE html>
        <html>
            <head>${headInnerHtml()}</head>
            <body>$contentHtml</body>
        </html>
        """
    }

    private fun headInnerHtml(): String {
        return """
        <meta charset="utf-8"/>
        <style>${fullCss()}</style>
        """
    }

    private fun fullCss(): String {
        return """
        body {
            background-color: #FFFF00;
        }
        """
    }
}
