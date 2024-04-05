package com.sopt.now.compose.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme

@Composable
fun SoptButton(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(12.dp),
    text: String = "",
    padding: PaddingValues = PaddingValues(vertical = 18.dp),
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .padding(padding)
            .fillMaxWidth(),
        onClick = onClick,
        shape = shape,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1C6739)),
        contentPadding = padding
    ) {
        Text(
            text = text,
            color = Color(0xFFF9F9F9),
            fontSize = 16.sp,
            lineHeight = 20.sp
        )
    }
}

@Preview
@Composable
fun SoptButtonPreview() {
    NOWSOPTAndroidTheme {
        SoptButton(
            text = "SoptButton",
            onClick = {}
        )
    }
}