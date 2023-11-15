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

        versionCode = 1
        versionName = "1"
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