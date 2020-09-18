package dev.valvassori.detective.containers

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detective.R
import dev.valvassori.detective.components.CardList
import dev.valvassori.detective.components.DetectiveAppBar
import dev.valvassori.detective.components.DetectiveTabBar
import dev.valvassori.detective.components.theme.DetectiveTheme
import dev.valvassori.detective.domain.factory.GameCardFactory
import dev.valvassori.detective.domain.model.Type

@Composable
fun MainContainer() {
    val image = imageResource(id = R.drawable.header)

    val (selectedTab, setTab) = remember { mutableStateOf(Type.CHARACTER) }
    val data = remember { GameCardFactory.make().groupBy { it.type } }

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
            Crossfade(current = selectedTab) {
                CardList(
                    cards = data[it].orEmpty()
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
