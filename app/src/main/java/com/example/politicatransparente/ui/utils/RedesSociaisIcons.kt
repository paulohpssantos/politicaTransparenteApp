package com.example.politicatransparente.ui.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import com.example.politicatransparente.R
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Facebook
import compose.icons.fontawesomeicons.brands.Instagram
import compose.icons.fontawesomeicons.brands.Youtube


@Composable
fun RedesSociaisIcons(urls: List<String>) {
    val uriHandler = LocalUriHandler.current
    Column {
        urls.forEach { url ->
            when {
                url.contains("facebook", ignoreCase = true) -> {
                    Badge(
                        "Facebook",
                        Color(0xFF1877F3),
                        FontAwesomeIcons.Brands.Facebook,
                        null,
                         { uriHandler.openUri(url) }
                    )
                }
                url.contains("twitter", ignoreCase = true) -> {
                    Badge(
                        "Twitter",
                        Color(0xFF000000),
                        null,
                        painterResource(id = R.drawable.x_twitter),
                        { uriHandler.openUri(url) }
                    )
                }
                url.contains("instagram", ignoreCase = true) -> {
                    Badge(
                        "Instagram",
                        Color(0xFFE4405F),
                        FontAwesomeIcons.Brands.Instagram,
                        null,
                        { uriHandler.openUri(url) }
                    )
                }
                url.contains("youtube", ignoreCase = true) -> {
                    Badge(
                        "YouTube",
                        Color(0xFFFF0000),
                        FontAwesomeIcons.Brands.Youtube,
                        null,
                        { uriHandler.openUri(url) }
                    )
                }

                else -> return@forEach
            }
        }
    }


}