package com.causa_arcana

import android.content.Context
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient

class CustomWebViewClient(private val context: Context): WebViewClient() {
    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest,
    ): WebResourceResponse? {
        val url = request.url.toString()

        if (url == "https://causa-arcana.com/assets/images/blog/decentralized-vs-distributed-wrong.png") {
            return WebResourceResponse("image/png", "utf-8",
                context.assets.open("decentralized-vs-distributed-wrong.png"))
        }

        if (url == "https://causa-arcana.com/assets/images/blog/network-topologies.png") {
            return WebResourceResponse("image/png", "utf-8",
                context.assets.open("network-topologies.png"))
        }

        return super.shouldInterceptRequest(view, request)
    }
}
