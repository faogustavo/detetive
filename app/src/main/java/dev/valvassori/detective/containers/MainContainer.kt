package dev.valvassori.detective.containers

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detective.R
import dev.valvassori.detective.components.DetectiveAppBar
import dev.valvassori.detective.components.DetectiveTabBar
import dev.valvassori.detective.components.theme.DetectiveTheme
import dev.valvassori.detective.domain.model.Type

@Composable
fun MainContainer() {
    val image = imageResource(id = R.drawable.header)

    val (selectedTab, setTab) = remember { mutableStateOf(Type.CHARACTER) }

    DetectiveTheme {
        Scaffold(
            topBar = {
                Column(Modifier.fillMaxWidth()) {
                    DetectiveAppBar(
                        showMenuButton = true,
                        showDivider = false
                    )
                    DetectiveTabBar(
                        selectedTab = selectedTab,
                        onTabSelected = setTab
                    )
                }
            },
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
    MainContainer()
}
