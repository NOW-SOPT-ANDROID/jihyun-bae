package com.sopt.now.compose.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeStickyHeader(
    title: String
) {
    Text(
        modifier = Modifier
            .background(Color(0xFFF9F9F9))
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 5.dp),
        text = title,
        fontSize = 20.sp,
        lineHeight = 16.sp,
        color = Color(0xFF3D3A3A)
    )
}