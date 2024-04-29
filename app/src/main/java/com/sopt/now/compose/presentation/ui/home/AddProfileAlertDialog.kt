package com.sopt.now.compose.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.R
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme
import com.sopt.now.compose.util.component.SoptButton
import com.sopt.now.compose.util.component.SoptTextField

@Composable
fun AddProfileAlertDialog(
    state: HomeContract.HomeState = HomeContract.HomeState(),
    clickBtn: () -> Unit = {},
    onValueChangeName: (String) -> Unit = {},
    onValueChangeSelfDescription: (String) -> Unit = {}
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_profile_74),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = context.getString(R.string.add_profile),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            textAlign = TextAlign.Center,
            text = context.getString(R.string.add_profile_description),
            fontSize = 16.sp,
            color = Color(0xFF878784),
            lineHeight = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        SoptTextField(
            placeholder = context.getString(R.string.add_profile_name_hint),
            value = state.inputName,
            title = context.getString(R.string.add_profile_name),
            onValueChange = onValueChangeName
        )
        Spacer(modifier = Modifier.height(10.dp))
        SoptTextField(
            placeholder = context.getString(R.string.add_profile_self_description_hint),
            value = state.inputSelfDescription,
            title = context.getString(R.string.add_profile_self_description),
            onValueChange = onValueChangeSelfDescription
        )
        Spacer(modifier = Modifier.height(28.dp))
        SoptButton(
            text = context.getString(R.string.add_profile_submit),
            onClick = { clickBtn() }
        )
    }
}

@Preview
@Composable
fun AddProfileAlertDialogPreview() {
    NOWSOPTAndroidTheme {
        AddProfileAlertDialog()
    }
}