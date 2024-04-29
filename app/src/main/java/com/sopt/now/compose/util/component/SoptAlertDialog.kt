package com.sopt.now.compose.util.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.sopt.now.compose.presentation.type.DialogType
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun SoptAlertDialog(
    modifier: Modifier = Modifier,
    dialogType: DialogType = DialogType.LOGOUT,
    clickLeftBtn: () -> Unit = {},
    clickRightBtn: () -> Unit = {}
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = dialogType.icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = context.getString(dialogType.title),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            textAlign = TextAlign.Center,
            text = context.getString(dialogType.description),
            fontSize = 16.sp,
            color = Color(0xFF878784),
            lineHeight = 20.sp
        )
        Spacer(modifier = Modifier.height(28.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            SoptButton(
                modifier = Modifier
                    .fillMaxWidth(0.5f),
                text = context.getString(dialogType.leftBtnText),
                backgroundColor = Color(0xFFEBEBEB),
                textColor = Color(0xFF878784),
                onClick = { clickLeftBtn() }
            )
            Spacer(modifier = Modifier.width(12.dp))
            SoptButton(
                text = context.getString(dialogType.rightBtnText),
                onClick = { clickRightBtn() }
            )
        }
    }
}

@Preview
@Composable
fun SoptAlertDialogPreview() {
    NOWSOPTAndroidTheme {
        SoptAlertDialog()
    }
}