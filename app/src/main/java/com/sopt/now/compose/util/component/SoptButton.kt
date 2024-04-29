package com.sopt.now.compose.util.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme
import com.sopt.now.compose.util.modifier.noRippleClickable

@Composable
fun SoptButton(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(12.dp),
    backgroundColor: Color = Color(0xFF1C6739),
    textColor: Color = Color(0xFFF9F9F9),
    text: String = "",
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .noRippleClickable(
                onClick = onClick
            )
            .clip(shape = shape)
            .background(
                color = backgroundColor,
                shape = shape
            )
            .padding(vertical = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
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