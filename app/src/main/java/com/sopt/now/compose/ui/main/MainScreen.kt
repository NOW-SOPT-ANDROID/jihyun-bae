package com.sopt.now.compose.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.R
import com.sopt.now.compose.ui.model.UserModel
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme

@Composable
fun MainScreen(
    userModel: UserModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "마이페이지",
            color = Color(0xFF000000),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_profile_74),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    modifier = Modifier
                        .background(color = Color(0xFFFFCFC0), shape = RoundedCornerShape(12.dp))
                        .padding(vertical = 4.dp, horizontal = 10.dp),
                    text = userModel.mbti,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = Color(0xFFF0683E)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = userModel.nickname,
                    fontSize = 20.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3D3A3A)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "id : " + userModel.id,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = Color(0xFF878784)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    NOWSOPTAndroidTheme {
        MainScreen(
            userModel = UserModel(
                id = "jihyunniiii",
                password = "aaaa1111",
                nickname = "지현",
                mbti = "ESFJ"
            )
        )
    }
}