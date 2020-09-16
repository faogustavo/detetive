package dev.valvassori.detective.components.core

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.valvassori.detective.R
import dev.valvassori.detective.components.ext.ComposableFn
import dev.valvassori.detective.components.theme.DetectiveTheme

@Composable
fun DetectiveAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    showBackButton: Boolean = false,
    showMenuButton: Boolean = false,
    onBackPress: () -> Unit = {},
) {
    val appIcon: ComposableFn = {
        Icon(
            asset = Icons.Outlined.ArrowBack,
            modifier = Modifier
                .gravity(Alignment.CenterVertically)
                .clickable(onClick = onBackPress)
                .padding(16.dp)
        )
    }

    val actions: @Composable RowScope.() -> Unit = {
        if (showMenuButton) {
            Icon(
                asset = Icons.Outlined.MoreVert,
                modifier = Modifier
                    .clickable(onClick = {})
                    .padding(horizontal = 12.dp, vertical = 16.dp)
                    .preferredHeight(24.dp)
            )
        }
    }

    Column {
        TopAppBar(
            modifier = modifier,
            elevation = 4.dp,
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
            actions = actions,
            title = {
                val finalTitle = title ?: stringResource(id = R.string.app_name)
                Text(text = finalTitle)
            },
            navigationIcon = appIcon.takeIf { showBackButton }
        )
        Divider()
    }
}

@Composable
@Preview
fun AppBarPreview() {
    DetectiveTheme {
        DetectiveAppBar(
            title = "Detetive",
            showBackButton = true,
            showMenuButton = true
        )
    }
}
