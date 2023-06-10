plugins {
    id("android-application-setup")
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(project(":mvvm-core"))
                implementation(project(":mvvm-compose"))
                implementation(project(":sample"))

                implementation(libs.bundles.androidApp)
            }
        }
    }
}

android {
    namespace = "io.github.dmitriy1892.kmm.mvvm.android"

    defaultConfig {
        applicationId = "io.github.dmitriy1892.kmm.mvvm.android"

        val versionMajor = libs.versions.appVersionMajor.get().toInt()
        val versionMinor = libs.versions.appVersionMinor.get().toInt()
        val versionPatch = libs.versions.appVersionPatch.get().toInt()

        versionCode = versionMajor * 10000 + versionMinor * 100 + versionPatch
        versionName = "$versionMajor.$versionMinor.$versionPatch"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.android.compose.compiler.get()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}