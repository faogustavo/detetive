package dev.valvassori.detetive.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
}

object DefaultDispatcherProvider : DispatcherProvider {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
}
