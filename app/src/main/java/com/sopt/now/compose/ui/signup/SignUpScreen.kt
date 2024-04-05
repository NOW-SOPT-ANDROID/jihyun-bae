package com.sopt.now.compose.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.component.SoptButton
import com.sopt.now.compose.ui.component.SoptTextField
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme

@Composable
fun SignUpScreen(
    onClickSignUpBtn: () -> Unit = {}
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }
    var mbti by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "회원가입",
            color = Color(0xFF000000),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        SoptTextField(
            title = "ID",
            onValueChange = { id = it },
            placeholder = "ID를 입력해 주세요"
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = "비밀번호",
            onValueChange = { password = it },
            placeholder = "비밀번호를 입력해 주세요"
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = "닉네임",
            onValueChange = { nickname = it },
            placeholder = "닉네임을 입력해 주세요"
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = "MBTI",
            onValueChange = { password = it },
            placeholder = "MBTI를 입력해 주세요"
        )
        Spacer(modifier = Modifier.weight(1f))
        SoptButton(
            text = "회원가입",
            onClick = onClickSignUpBtn
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    NOWSOPTAndroidTheme {
        SignUpScreen()
    }
}