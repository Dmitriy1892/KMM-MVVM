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
                implementation(project(":mvvm-core"))

                implementation(libs.koin.core)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.lifecycle.viewmodel)
            }
        }
    }
}

android {
    namespace = "io.github.dmitriy1892.kmm.mvvm.koin"
}