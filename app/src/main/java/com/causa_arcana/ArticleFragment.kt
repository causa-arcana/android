package com.causa_arcana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

class ArticleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleWebView: WebView = view.findViewById(R.id.fragment_article__article_web_view)

        val customWebViewClient = CustomWebViewClient(requireContext())
        articleWebView.webViewClient = customWebViewClient

        articleWebView.loadUrl("https://causa-arcana.com/blog/2021/08/06/writing-about-it.html")
    }
}
