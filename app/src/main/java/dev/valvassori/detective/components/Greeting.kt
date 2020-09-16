package dev.valvassori.detective.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detective.R
import dev.valvassori.detective.components.core.DetectiveAppBar
import dev.valvassori.detective.components.theme.DetectiveTheme

@Composable
fun Greeting() {
    val image = imageResource(id = R.drawable.header)
    DetectiveTheme {
        Scaffold(
            topBar = {
                DetectiveAppBar(showMenuButton = true)
            }
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                val typography = MaterialTheme.typography
                val imageModifier = Modifier
                    .fillMaxWidth()
                    .preferredHeightIn(180.dp, 180.dp)
                    .clip(shape = RoundedCornerShape(size = 4.dp))

                Image(
                    asset = image,
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "A day wandering through the sandhills " +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw foo bar lorem ipsum",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Davenport, California",
                    style = typography.body2
                )
                Text(
                    text = "December 2018",
                    style = typography.body2
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewGreeting() {
    Greeting()
}
