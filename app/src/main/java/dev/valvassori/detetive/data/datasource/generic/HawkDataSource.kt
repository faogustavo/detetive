package dev.valvassori.detetive.data.datasource.generic

import com.orhanobut.hawk.Hawk

class HawkDataSource<T>(private val key: String) {

    fun get(): T = Hawk.get<T>(key)

    fun set(value: T) {
        Hawk.put(key, value)
    }

    fun exists() = Hawk.contains(key)
}
