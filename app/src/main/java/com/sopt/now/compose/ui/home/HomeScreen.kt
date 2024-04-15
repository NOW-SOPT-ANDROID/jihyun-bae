package com.sopt.now.compose.ui.home

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sopt.now.compose.R
import com.sopt.now.compose.model.UserModel
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun HomeRoute(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(true) {
        navController.previousBackStackEntry?.savedStateHandle?.run {
            get<UserModel>("user")?.let { userModel: UserModel ->
                viewModel.setUserInfo(userModel = userModel)
            }
        }
    }

    HomeScreen(
        state = uiState
    )
}

@Composable
fun HomeScreen(
    state: HomeContract.HomeState = HomeContract.HomeState()
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = context.getString(R.string.my_page_my_page),
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
                state.user?.let {
                    Text(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFFFCFC0),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(vertical = 4.dp, horizontal = 10.dp),
                        text = it.mbti,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        color = Color(0xFFF0683E)
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                state.user?.let {
                    Text(
                        text = it.nickname,
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF3D3A3A)
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "id : " + (state.user?.id ?: ""),
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
        HomeScreen()
    }
}