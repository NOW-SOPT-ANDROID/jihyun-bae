package com.sopt.now.compose.presentation.ui.follower

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.sopt.now.compose.domain.model.ReqresUserEntity
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun FollowerContainer(
    modifier: Modifier = Modifier,
    reqresUserEntity: ReqresUserEntity
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(1f)
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val profileSize = 50.dp
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = reqresUserEntity.avatar)
                        .apply(block = fun ImageRequest.Builder.() {
                            transformations(CircleCropTransformation())
                        }).build()
                ),
                contentDescription = null,
                modifier = modifier.size(profileSize)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = reqresUserEntity.lastName,
                    fontSize = 20.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3D3A3A)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = reqresUserEntity.email,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = Color(0xFF878784)
                )
            }
        }
    }
}

@Composable
@Preview
fun FriendProfileContainerPreview() {
    NOWSOPTAndroidTheme {
        FollowerContainer(
            reqresUserEntity = ReqresUserEntity(
                id = 0,
                avatar = "https://avatars.githubusercontent.com/u/103172971?v=4",
                firstName = "ㅋㅋ",
                lastName = "배지현",
                email = "어쩌구저쩌구"
            )
        )
    }
}