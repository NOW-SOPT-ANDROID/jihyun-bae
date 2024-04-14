package com.sopt.now.compose.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavController
import com.sopt.now.compose.R
import com.sopt.now.compose.component.SoptButton
import com.sopt.now.compose.component.SoptTextField
import com.sopt.now.compose.model.UserModel
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme
import com.sopt.now.compose.util.context.showToast

@Composable
fun SignUpRoute(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel(),
    navigateToSignIn: (UserModel) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { signUpSideEffect ->
                when (signUpSideEffect) {
                    is SignUpContract.SignUpSideEffect.NavigateToSignIn -> {
                        navigateToSignIn(signUpSideEffect.userModel)
                    }

                    is SignUpContract.SignUpSideEffect.showToast -> {
                        with(context) {
                            showToast(getString(signUpSideEffect.signUpType.descriptionRes))
                        }
                    }
                }
            }
    }

    SignUpScreen(
        state = uiState,
        onSignUpBtnClicked = viewModel::signUp,
        onValueChangeId = viewModel::updateId,
        onValueChangePassword = viewModel::updatePassword,
        onValueChangeNickname = viewModel::updateNickname,
        onValueChangeMbti = viewModel::updateMbti
    )
}

@Composable
fun SignUpScreen(
    state: SignUpContract.SignUpState = SignUpContract.SignUpState(),
    onSignUpBtnClicked: () -> Unit = {},
    onValueChangeId: (String) -> Unit = {},
    onValueChangePassword: (String) -> Unit = {},
    onValueChangeNickname: (String) -> Unit = {},
    onValueChangeMbti: (String) -> Unit = {}
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
            text = context.getString(R.string.sign_up_sign_up),
            color = Color(0xFF000000),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        SoptTextField(
            title = context.getString(R.string.sign_id),
            value = state.user.id,
            onValueChange = onValueChangeId,
            placeholder = context.getString(R.string.sign_id_hint)
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = context.getString(R.string.sign_password),
            value = state.user.password,
            onValueChange = onValueChangePassword,
            placeholder = context.getString(R.string.sign_password_hint),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = context.getString(R.string.sign_nickname),
            value = state.user.nickname,
            onValueChange = onValueChangeNickname,
            placeholder = context.getString(R.string.sign_nickname_hint)
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = context.getString(R.string.sign_mbti),
            value = state.user.mbti,
            onValueChange = onValueChangeMbti,
            placeholder = context.getString(R.string.sign_mbti_hint)
        )
        Spacer(modifier = Modifier.weight(1f))
        SoptButton(
            text = context.getString(R.string.sign_up_sign_up),
            onClick = onSignUpBtnClicked
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