package com.causa_arcana

import android.content.Context
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient

class CustomWebViewClient(private val context: Context) : WebViewClient() {
    companion object {
        private const val HOST = "causa-arcana.com"
        private const val SCHEME = "https"
        private const val NO_PORT = -1
        private const val PORT = 443
    }

    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest,
    ): WebResourceResponse? {
        if (!relatedHost(request)) return super.shouldInterceptRequest(view, request)

        if (!validComponents(request)) return teapotResponse()

        return when (request.url.path) {
            "/blog/2021/08/06/writing-about-it.html" -> generatedHtmlResponse(
                "Почему сложно писать о передовых информационных технологиях?",
                "writing-about-it.html",
            )
            "/assets/images/blog/decentralized-vs-distributed-wrong.png" ->
                assetResponse("image/png",
                    "decentralized-vs-distributed-wrong.png")
            "/assets/images/blog/network-topologies.png" ->
                assetResponse("image/png", "network-topologies.png")
            else -> teapotResponse()
        }
    }

    private fun relatedHost(request: WebResourceRequest): Boolean {
        return request.url.host?.lowercase() == HOST
    }

    private fun validComponents(request: WebResourceRequest): Boolean {
        return request.url.scheme?.lowercase() == SCHEME &&
                request.url.userInfo == null &&
                (request.url.port == NO_PORT || request.url.port == PORT) &&
                request.url.query == null &&
                request.url.fragment == null
    }

    private fun teapotResponse(): WebResourceResponse {
        return WebResourceResponse(
            "text/plain", "utf-8", 418, "I'm a teapot",
            null, null,
        )
    }

    private fun generatedHtmlResponse(title: String, assetFileName: String):
            WebResourceResponse {
        val inputStream = context.assets.open(assetFileName)
        val contentHtml = inputStream.bufferedReader().use { it.readText() }
        val htmlGenerator = HtmlGenerator(title, contentHtml)
        val data = htmlGenerator.fullHtml().byteInputStream()
        return WebResourceResponse("text/html", "utf-8", data)
    }

    private fun assetResponse(mimeType: String, assetFileName: String):
            WebResourceResponse {
        return WebResourceResponse(mimeType, "utf-8", context.assets.open(assetFileName))
    }
}
