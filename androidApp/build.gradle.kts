plugins {
    id("android-application-setup")
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(project(":kmm-mvvm-core"))
                implementation(project(":kmm-mvvm-compose"))

                implementation(libs.bundles.androidApp)
            }
        }
    }
}

android {
    namespace = "com.coldfier.kmm.mvvm.android"

    defaultConfig {
        applicationId = "com.coldfier.kmm.mvvm.android"

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