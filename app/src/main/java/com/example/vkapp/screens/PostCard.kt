package com.example.vkapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkapp.R
import com.example.vkapp.ui.theme.VkAppTheme


@Composable
fun PostCard() {

    Card {
        Column (modifier = Modifier
            .padding(8.dp)){
            PostHeader()
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = stringResource(R.string.template_text), fontWeight = Bold)
            Spacer(modifier = Modifier.padding(8.dp))
            Image(painter = painterResource(id = R.drawable.post_content_image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                contentScale = ContentScale.FillWidth)
            Spacer(modifier = Modifier.padding(8.dp))
            Statistics()
        }
    }
}

@Composable
private fun PostHeader(){
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.post_comunity_thumbnail),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = stringResource(R.string.devnull_text), fontWeight = Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "14:00",
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
private fun Statistics(){
    Row {
        Row(modifier = Modifier.weight(1f)) {
            IconWidthText(iconResId = R.drawable.ic_views_count, text = stringResource(R.string._206_text))
        }
        Row(modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween) {
            IconWidthText(iconResId = R.drawable.ic_share, text = stringResource(R.string._208_text))
            IconWidthText(iconResId = R.drawable.ic_comment, text = stringResource(R.string._11_text))
            IconWidthText(iconResId = R.drawable.ic_like, text = stringResource(R.string._491_text))
        }
    }
}

@Composable
private fun IconWidthText(
    iconResId: Int,
    text : String
){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = text,
            color = MaterialTheme.colorScheme.onSecondary)
    }
}

@Preview
@Composable
fun PreviewCardLight(){
    VkAppTheme(
        darkTheme = false
    ) {
        PostCard()
    }
}

@Preview
@Composable
fun PreviewCardDark(){
    VkAppTheme(
        darkTheme = true
    ) {
        PostCard()
    }
}