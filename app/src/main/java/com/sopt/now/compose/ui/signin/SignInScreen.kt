package com.sopt.now.compose.ui.signin

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.component.SoptButton
import com.sopt.now.compose.ui.component.SoptTextField
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme

@Composable
fun SignInScreen(
    onClickSignUpText: () -> Unit = {},
    onClickSignInBtn: () -> Unit = {}
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "로그인",
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
            onValueChange = { id = it },
            placeholder = "비밀번호를 입력해 주세요"
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "계정이 없으신가요?",
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = Color(0xFFCBC8C5)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier
                .clickable { onClickSignUpText }
                .align(Alignment.CenterHorizontally),
            text = "회원가입하기",
            fontSize = 14.sp,
            lineHeight = 18.sp,
            style = TextStyle(textDecoration = TextDecoration.Underline),
            color = Color(0xFF656565)

        )
        Spacer(modifier = Modifier.height(6.dp))
        SoptButton(
            text = "로그인",
            onClick = onClickSignInBtn
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    NOWSOPTAndroidTheme {
        SignInScreen()
    }
}