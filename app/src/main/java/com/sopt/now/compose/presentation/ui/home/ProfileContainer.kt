package com.sopt.now.compose.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.sopt.now.compose.R
import com.sopt.now.compose.domain.model.ProfileEntity
import com.sopt.now.compose.theme.NOWSOPTAndroidTheme

@Composable
fun ProfileContainer(
    modifier: Modifier = Modifier,
    profileEntity: ProfileEntity
) {
    val context = LocalContext.current

    (profileEntity.id == 0).let { isMyProfile ->
        Column(
            modifier = modifier
                .padding(horizontal = 24.dp)
        ) {
            if (isMyProfile) {
                Spacer(modifier = Modifier.height(60.dp))
                Text(
                    text = context.getString(R.string.main_navigation_item_home),
                    fontSize = 32.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3D3A3A)
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            Row(
                modifier = modifier
                    .fillMaxWidth(1f)
                    .wrapContentHeight()
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val profileSize = if (isMyProfile) 70.dp else 50.dp
                Image(
                    painter = rememberImagePainter(
                        data = profileEntity.profileImage,
                        builder = {
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = null,
                    modifier = modifier.size(profileSize)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(
                        text = profileEntity.name,
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF3D3A3A)
                    )
                    profileEntity.selfDescription?.let {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = it,
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            color = Color(0xFF878784)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun FriendProfileContainerPreview() {
    NOWSOPTAndroidTheme {
        ProfileContainer(
            profileEntity = ProfileEntity(
                id = 0,
                profileImage = "https://avatars.githubusercontent.com/u/103172971?v=4",
                name = "배지현",
                selfDescription = "어쩌구저쩌구"
            )
        )
    }
}