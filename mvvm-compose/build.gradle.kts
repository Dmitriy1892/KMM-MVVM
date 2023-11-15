plugins {
    id("multiplatform-compose-setup")

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
        commonMain{
            dependencies {
                implementation(project(":mvvm-core"))
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.compose.viewmodel)
            }
        }
    }
}

android {
    namespace = "io.github.dmitriy1892.kmm.mvvm.compose"
}