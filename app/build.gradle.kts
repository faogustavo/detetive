plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs")
}

android {
    compileSdkVersion(ReleaseVersions.sdk)
    buildToolsVersion(ReleaseVersions.buildTools)

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin/")
        getByName("test").java.srcDirs("src/test/kotlin/")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin/")
    }

    defaultConfig {
        minSdkVersion(ReleaseVersions.minSdk)
        targetSdkVersion(ReleaseVersions.sdk)
        applicationId = ReleaseVersions.appId
        versionCode = ReleaseVersions.versionCode
        versionName = ReleaseVersions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerVersion = Libs.Kotlin.version
        kotlinCompilerExtensionVersion = Libs.Compose.version
    }
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + arrayOf(
            "-Xallow-jvm-ir-dependencies",
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xopt-in=kotlin.OptIn",
            "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-Xopt-in=kotlinx.coroutines.FlowPreview",
            "-Xopt-in=kotlin.Experimental"
        )
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.Kotlin.lib)

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.constraintLayout)

    implementation(Libs.AndroidX.LifeCycle.core)
    implementation(Libs.AndroidX.LifeCycle.viewModel)

    implementation(Libs.Compose.foundation)
    implementation(Libs.Compose.material)
    implementation(Libs.Compose.materialIconsExtended)
    implementation(Libs.Compose.tooling)

    implementation(Libs.Navigation.fragment)
    implementation(Libs.Navigation.ui)

    implementation(Libs.Koin.core)
    implementation(Libs.Koin.android)
    implementation(Libs.Koin.viewModel)

    implementation(Libs.Hawk.lib)

    testImplementation(Libs.Test.junit)
    testImplementation(Libs.Test.mockk)

    androidTestImplementation(Libs.Test.androidJunit)
    androidTestImplementation(Libs.Test.espresso)
}
