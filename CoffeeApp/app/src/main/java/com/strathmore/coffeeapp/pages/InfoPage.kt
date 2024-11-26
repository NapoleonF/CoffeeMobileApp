package com.strathmore.coffeeapp.pages

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun MyWebView() {
    val url = "https://firtman.github.io/coffeemasters/webapp"
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient() // Correctly assign the WebViewClient
                loadUrl(url) // Load the URL
            }
        },
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}

@Composable
fun InfoPage(modifier: Modifier = Modifier){
    MyWebView()
}
