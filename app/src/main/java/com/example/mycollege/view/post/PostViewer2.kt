package com.example.mycollege.view.post

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycollege.R
import com.example.mycollege.view.lectuers.PdfViewer


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostViewer2() {
    var isLoading by remember { mutableStateOf(false) }
    var currentLoadingPage by remember { mutableStateOf<Int?>(null) }
    var pageCount by remember { mutableStateOf<Int?>(null) }

    Box {
        PdfViewer(
            modifier = Modifier.fillMaxSize(),
            pdfResId = R.raw.post2,
            loadingListener = { loading, currentPage, maxPage ->
                isLoading = loading
                if (currentPage != null) currentLoadingPage = currentPage
                if (maxPage != null) pageCount = maxPage
            }
        )
        if (isLoading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    progress = if (currentLoadingPage == null || pageCount == null) 0f
                    else currentLoadingPage!!.toFloat() / pageCount!!.toFloat()
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 5.dp)
                        .padding(horizontal = 30.dp),
                    text = "${currentLoadingPage ?: "-"} pages loaded/${pageCount ?: "-"} total pages"
                )
            }
        }
    }



}