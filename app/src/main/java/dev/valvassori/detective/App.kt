package dev.valvassori.detective

import android.app.Application
import com.orhanobut.hawk.Hawk
import dev.valvassori.detective.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Hawk.init(applicationContext).build()

        startKoin {
            androidContext(this@App)
            modules(viewModelModule)
        }
    }
}
