object ReleaseVersions {
    const val minSdk = 21
    const val sdk = 29
    const val buildTools = "30.0.1"

    const val versionCode = 1
    const val versionName = "1.0.0"
    const val appId = "dev.valvassori.detetive"
}

object BuildDependencies {
    const val gradle = "com.android.tools.build:gradle:4.2.0-alpha11"
    const val kotlin = "gradle-plugin"
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Libs.Navigation.version}"
}

object Libs {
    object Kotlin {
        const val version = "1.4.10"
        const val lib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.3.1"
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.1"

        object LifeCycle {
            const val version = "2.2.0"

            const val core = "androidx.lifecycle:lifecycle-extensions:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }
    }

    object Koin {
        const val version = "2.1.6"

        const val core = "org.koin:koin-core:$version"
        const val android = "org.koin:koin-android:$version"
        const val viewModel = "org.koin:koin-android-viewmodel:$version"
    }

    object Compose {
        const val version = "1.0.0-alpha03"

        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val layout = "androidx.compose.foundation:foundation-layout:$version"

        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val materialIconsExtended =
            "androidx.compose.material:material-icons-extended:$version"

        const val tooling = "androidx.ui:ui-tooling:$version"
        const val test = "androidx.ui:ui-test:$version"
    }

    object Navigation {
        const val version = "2.3.0"

        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object Hawk {
        const val lib = "com.orhanobut:hawk:2.0.1"
    }

    object Test {
        const val junit = "junit:junit:4.12"
        const val mockk = "io.mockk:mockk:1.10.0"

        const val androidJunit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }
}
