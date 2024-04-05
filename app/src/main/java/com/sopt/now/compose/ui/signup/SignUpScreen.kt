package com.sopt.now.compose.ui.signup

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.component.SoptButton
import com.sopt.now.compose.ui.component.SoptTextField
import com.sopt.now.compose.ui.model.UserModel
import com.sopt.now.compose.ui.signin.SignInActivity
import com.sopt.now.compose.ui.signin.SignInActivity.Companion.USER_INFO
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme
import com.sopt.now.compose.util.context.showToast

@Composable
fun SignUpScreen() {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }
    var mbti by remember { mutableStateOf("") }
    val context = LocalContext.current

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
            value = id,
            onValueChange = { id = it },
            placeholder = "ID를 입력해 주세요"
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = "비밀번호",
            value = password,
            onValueChange = { password = it },
            placeholder = "비밀번호를 입력해 주세요"
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = "닉네임",
            value = nickname,
            onValueChange = { nickname = it },
            placeholder = "닉네임을 입력해 주세요"
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = "MBTI",
            value = mbti,
            onValueChange = { mbti = it },
            placeholder = "MBTI를 입력해 주세요"
        )
        Spacer(modifier = Modifier.weight(1f))
        SoptButton(
            text = "회원가입",
            onClick = {
                context.showToast(
                    when {
                        id.length !in 6..10 -> "아이디를 확인해 주세요."
                        password.length !in 8..12 -> "비밀번호를 확인해 주세요."
                        nickname.isEmpty() -> "닉네임을 확인해 주세요."
                        !mbti.matches(Regex("^[EI][NS][FT][JP]\$")) -> "MBTI를 확인해 주세요"
                        else -> {
                            Intent(context, SignInActivity::class.java).apply {
                                putExtra(
                                    USER_INFO,
                                    UserModel(
                                        id = id,
                                        password = password,
                                        nickname = nickname,
                                        mbti = mbti
                                    )
                                )
                                (context as? Activity)?.let { activity ->
                                    activity.setResult(RESULT_OK, this)
                                    activity.finish()
                                }
                            }
                            "회원가입에 성공하였습니다"
                        }
                    }
                )
            }
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