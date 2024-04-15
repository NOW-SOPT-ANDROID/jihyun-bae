package com.sopt.now.compose.ui.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
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
fun SignInRoute(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel(),
    popBackStack: () -> Unit,
    navigateToHome: (UserModel) -> Unit,
    navigateToSignUp: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { signInSideEffect ->
                when (signInSideEffect) {
                    SignInContract.SignInSideEffect.NavigateToSignUp -> {
                        navigateToSignUp()
                    }

                    SignInContract.SignInSideEffect.PopBackStack -> {
                        popBackStack()
                    }

                    is SignInContract.SignInSideEffect.NavigateToHome -> {
                        navigateToHome(signInSideEffect.user)
                    }

                    is SignInContract.SignInSideEffect.ShowToast -> {
                        with(context) {
                            showToast(getString(signInSideEffect.message))
                        }
                    }
                }
            }
    }

    LaunchedEffect(true) {
        navController.previousBackStackEntry?.savedStateHandle?.run {
            get<UserModel>("user")?.let { userModel: UserModel ->
                viewModel.setUserInfo(userModel = userModel)
            }
        }
    }

    SignInScreen(
        state = uiState,
        onSignUpTvClicked = viewModel::signUp,
        onSignInBtnClicked = viewModel::signIn,
        onValueChangeId = viewModel::updateId,
        onValueChangePassword = viewModel::updatePassword
    )
}

@Composable
fun SignInScreen(
    state: SignInContract.SignInState = SignInContract.SignInState(),
    onSignUpTvClicked: () -> Unit = {},
    onSignInBtnClicked: () -> Unit = {},
    onValueChangeId: (String) -> Unit = {},
    onValueChangePassword: (String) -> Unit = {}
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .imePadding()
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = context.getString(R.string.sign_in_sign_in),
            color = Color(0xFF000000),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        SoptTextField(
            title = context.getString(R.string.sign_id),
            value = state.inputId,
            onValueChange = onValueChangeId,
            placeholder = context.getString(R.string.sign_id_hint)
        )
        Spacer(modifier = Modifier.height(20.dp))
        SoptTextField(
            title = context.getString(R.string.sign_password),
            value = state.inputPassword,
            onValueChange = onValueChangePassword,
            placeholder = context.getString(R.string.sign_password_hint),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = context.getString(R.string.sign_in_no_account),
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = Color(0xFFCBC8C5)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(modifier = Modifier
            .clickable {
                onSignUpTvClicked()
            }
            .align(Alignment.CenterHorizontally),
            text = context.getString(R.string.sign_in_sign_up),
            fontSize = 14.sp,
            lineHeight = 18.sp,
            style = TextStyle(textDecoration = TextDecoration.Underline),
            color = Color(0xFF656565)

        )
        Spacer(modifier = Modifier.height(6.dp))
        SoptButton(
            text = context.getString(R.string.sign_in_sign_in), onClick = onSignInBtnClicked
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