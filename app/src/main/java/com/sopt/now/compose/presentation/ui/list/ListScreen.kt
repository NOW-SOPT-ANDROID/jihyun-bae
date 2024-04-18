package com.sopt.now.compose.presentation.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun ListRoute() {
    ListScreen()
}

@Composable
fun ListScreen() {
    Text(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        text = "리스트"
    )
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    NOWSOPTAndroidTheme {
        ListScreen()
    }
}