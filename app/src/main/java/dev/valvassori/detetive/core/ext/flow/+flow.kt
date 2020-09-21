package dev.valvassori.detetive.core.ext.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect

suspend fun <T> Flow<T>.collectTo(other: MutableStateFlow<T>) {
    collect { other.value = it }
}
