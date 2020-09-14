object ReleaseVersions {
    const val minSdk = 21
    const val sdk = 29
    const val buildTools = "30.0.1"

    const val versionCode = 1
    const val versionName = "1.0.0"
    const val appId = "dev.valvassori.detective"
}

object Versions {
    const val kotlin = "1.4.10"
    const val agp = "4.0.1"

    const val appcompat = "1.2.0"
    const val coreKtx = "1.3.1"
    const val constraintLayout = "2.0.1"
    const val lifecycle = "2.2.0"
    const val hawk = "2.0.1"
    const val koin = "2.1.6"

    const val junit = "4.12"

    const val androidJunit = "1.1.2"
    const val espresso = "3.3.0"
}

object BuildDependencies {
    val gradle = "com.android.tools.build:gradle:${Versions.agp}"
    val kotlin = "gradle-plugin"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    const val hawk = "com.orhanobut:hawk:${Versions.hawk}"

    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    // TEST
    const val junit = "junit:junit:${Versions.junit}"

    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
