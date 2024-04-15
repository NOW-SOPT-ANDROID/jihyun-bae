package com.sopt.now.compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun SoptTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    title: String = "",
    value: String = "",
    onValueChange: (String) -> Unit = { _ -> },
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    Column(
        modifier = modifier
            .background(color = Color(0xFFFAF7F2), shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 18.dp, vertical = 14.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 20.sp,
            color = Color(0xFF878784)
        )
        Spacer(modifier = Modifier.padding(top = 4.dp))
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            cursorBrush = SolidColor(Color.Black),
            singleLine = true,
            keyboardActions = KeyboardActions.Default,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            visualTransformation = visualTransformation,
            textStyle = TextStyle(fontSize = 18.sp, color = Color(0xFF262525), lineHeight = 23.sp),
            decorationBox = { innerTextField ->
                innerTextField()
                if (value.isEmpty()) {
                    Text(
                        fontSize = 18.sp,
                        color = Color(0xFFCBC8C5),
                        lineHeight = 23.sp,
                        text = placeholder
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun SoptEditTextPreview() {
    NOWSOPTAndroidTheme {
        SoptTextField(
            title = "제목",
            placeholder = "hint"
        )
    }
}