plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
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
        kotlinCompilerVersion = Versions.kotlin
        kotlinCompilerExtensionVersion = Libs.Compose.version
    }
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs =
            freeCompilerArgs + arrayOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.constraintLayout)

    implementation(Libs.lifecycle)
    implementation(Libs.viewModel)

    implementation(Libs.hawk)

    implementation(Libs.koinCore)
    implementation(Libs.koinAndroid)
    implementation(Libs.koinViewModel)

    implementation(Libs.Compose.foundation)
    implementation(Libs.Compose.material)
    implementation(Libs.Compose.materialIconsExtended)
    implementation(Libs.Compose.tooling)

    testImplementation(Libs.junit)

    androidTestImplementation(Libs.androidJunit)
    androidTestImplementation(Libs.espresso)
}
