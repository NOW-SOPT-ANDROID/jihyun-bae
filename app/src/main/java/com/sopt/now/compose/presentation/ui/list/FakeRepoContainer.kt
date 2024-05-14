package com.sopt.now.compose.presentation.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.domain.model.FakeRepoModel
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun FakeRepoContainer(
    modifier: Modifier = Modifier,
    fakeRepoModel: FakeRepoModel
) {
    Column(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(1f)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = fakeRepoModel.name,
            fontSize = 20.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3D3A3A)
        )
        fakeRepoModel.description?.let {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = it,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Color(0xFF878784)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color(0xFF878784))
        )
    }
}

@Composable
@Preview
fun FakeRepoContainerPreview() {
    NOWSOPTAndroidTheme {
        FakeRepoContainer(
            fakeRepoModel = FakeRepoModel(
                id = 0,
                name = "Repo Name",
                description = null
            )
        )
    }
}