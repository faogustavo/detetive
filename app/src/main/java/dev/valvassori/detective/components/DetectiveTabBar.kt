package dev.valvassori.detective.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope.gravity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.valvassori.detective.domain.model.Type

@Composable
fun DetectiveTabBar(
    selectedTab: Type,
    onTabSelected: (Type) -> Unit,
    modifier: Modifier = Modifier,
) {
    val types = listOf(Type.CHARACTER, Type.PLACE, Type.WEAPON)
    val selectedIndex = types.indexOf(selectedTab)
    TabRow(
        selectedTabIndex = selectedIndex,
        modifier = modifier,
        indicator = { tabPositions ->
            DetectiveTabBarIndicator(
                Modifier.defaultTabIndicatorOffset(tabPositions[selectedIndex])
            )
        }
    ) {
        types.forEachIndexed { index, type ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onTabSelected(type) },
                text = { Text(text = stringResource(id = type.title).toUpperCase()) }
            )
        }
    }
}

@Composable
fun DetectiveTabBarIndicator(
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier.preferredWidth(112.dp)
            .preferredHeight(4.dp)
            .gravity(Alignment.CenterHorizontally)
            .background(
                MaterialTheme.colors.secondary,
                RoundedCornerShape(topLeftPercent = 25, topRightPercent = 25)
            )
    )
}
