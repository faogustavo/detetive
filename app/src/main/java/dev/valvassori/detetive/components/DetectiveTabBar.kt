package dev.valvassori.detetive.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detetive.components.theme.DetectiveTheme
import dev.valvassori.detetive.core.ext.compose.TypedComposableFn
import dev.valvassori.detetive.core.ext.func.Callback1
import dev.valvassori.detetive.domain.model.Type

@Composable
fun DetectiveTabBar(
    selectedTab: Type,
    onTabSelected: Callback1<Type>,
    modifier: Modifier = Modifier,
) {
    val types = listOf(Type.CHARACTER, Type.PLACE, Type.WEAPON)
    val selectedIndex = types.indexOf(selectedTab)

    val indicator: TypedComposableFn<List<TabPosition>> = { tabPositions ->
        DetectiveTabBarIndicator(
            Modifier.defaultTabIndicatorOffset(tabPositions[selectedIndex])
        )
    }

    TabRow(
        selectedTabIndex = selectedIndex,
        modifier = modifier,
        indicator = indicator,
    ) {
        types.forEachIndexed { index, type ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onTabSelected(type) },
                text = {
                    Text(
                        text = stringResource(id = type.title),
                        maxLines = 1
                    )
                }
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
            .align(Alignment.CenterHorizontally)
            .background(
                MaterialTheme.colors.secondary,
                RoundedCornerShape(topLeftPercent = 25, topRightPercent = 25)
            )
    )
}

@Composable
@Preview
fun PreviewDetectiveTabBar() {
    DetectiveTheme {
        DetectiveTabBar(
            selectedTab = Type.CHARACTER,
            onTabSelected = {}
        )
    }
}
