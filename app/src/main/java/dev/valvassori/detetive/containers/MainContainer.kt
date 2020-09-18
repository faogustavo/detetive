package dev.valvassori.detetive.containers

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
import dev.valvassori.detetive.R
import dev.valvassori.detetive.components.CardList
import dev.valvassori.detetive.components.DetectiveAppBar
import dev.valvassori.detetive.components.DetectiveTabBar
import dev.valvassori.detetive.components.theme.DetectiveTheme
import dev.valvassori.detetive.domain.factory.GameCardFactory
import dev.valvassori.detetive.domain.model.Type

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
