package com.sopt.now.compose.ui.signin

import android.app.Activity
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.component.SoptButton
import com.sopt.now.compose.ui.component.SoptTextField
import com.sopt.now.compose.ui.main.MainActivity
import com.sopt.now.compose.ui.model.UserModel
import com.sopt.now.compose.ui.signin.SignInActivity.Companion.USER_INFO
import com.sopt.now.compose.ui.signup.SignUpActivity
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme
import com.sopt.now.compose.util.context.showToast
import com.sopt.now.compose.util.intent.getCompatibleParcelableExtra

@Composable
fun SignInScreen() {
    val context = LocalContext.current
    var user by remember { mutableStateOf(UserModel("", "", "", "")) }
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var resultLauncher: ActivityResultLauncher<Intent> = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if (activityResult.resultCode == ComponentActivity.RESULT_OK) {
            activityResult.data?.getCompatibleParcelableExtra<UserModel>(SignInActivity.USER_INFO)
                ?.let { userModel ->
                    user = userModel
                }
        }
    }

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
            value = id,
            onValueChange = { id = it },
            placeholder = "ID를 입력해 주세요"
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = "비밀번호",
            value = password,
            onValueChange = { password = it },
            placeholder = "비밀번호를 입력해 주세요",
            visualTransformation = PasswordVisualTransformation()
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
                .clickable {
                    Intent(context, SignUpActivity::class.java).apply {
                        resultLauncher.launch(this)
                    }
                }
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
            onClick = {
                if (user.id == id && user.password == password) {
                    context.showToast("로그인 성공")
                    Intent(context, MainActivity::class.java).apply {
                        putExtra(USER_INFO, user)
                        (context as? Activity)?.startActivity(this)
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    NOWSOPTAndroidTheme {
        SignInScreen()
    }
}