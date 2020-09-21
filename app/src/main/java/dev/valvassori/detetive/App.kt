package dev.valvassori.detetive

import android.app.Application
import com.orhanobut.hawk.Hawk
import dev.valvassori.detetive.di.cacheModule
import dev.valvassori.detetive.di.coroutinesModule
import dev.valvassori.detetive.di.dataSourceModule
import dev.valvassori.detetive.di.repositoryModule
import dev.valvassori.detetive.di.useCaseModule
import dev.valvassori.detetive.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@ExperimentalCoroutinesApi
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Hawk.init(applicationContext).build()

        startKoin {
            androidContext(this@App)
            modules(
                coroutinesModule,
                cacheModule,
                dataSourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}
