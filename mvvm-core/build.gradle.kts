plugins {
    id("multiplatform-setup")

    id("publication-settings")
    id("maven-publish")
}

group = "io.github.dmitriy1892.kmm"
version = getMyLibraryVersion()

kotlin {
    androidTarget {
        publishLibraryVariants("release", "debug")
    }
    
    sourceSets {
        commonMain {
            dependencies {
                api(libs.kmm.utils)
                implementation(libs.kotlinx.coroutines.core)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.activity)
                implementation(libs.androidx.fragment)
            }
        }
    }
}

android {
    namespace = "io.github.dmitriy1892.kmm.mvvm.core"
}