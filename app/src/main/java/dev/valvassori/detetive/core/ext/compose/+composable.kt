package dev.valvassori.detetive.core.ext.compose

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

typealias ComposableFn = @Composable () -> Unit
typealias ComposableRowFn = @Composable RowScope.() -> Unit
typealias ComposableColumnFn = @Composable ColumnScope.() -> Unit
typealias TypedComposableFn<T> = @Composable (T) -> Unit
