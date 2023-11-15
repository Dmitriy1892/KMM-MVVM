plugins {
    id("multiplatform-compose-setup")

    id("publication-settings")
    id("maven-publish")
}

group = "io.github.dmitriy1892.kmm"
version = getMyLibraryVersion()

kotlin {
    android {
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
                api(libs.androidx.lifecycle.viewmodel)
                api(libs.androidx.lifecycle.compose.viewmodel)
            }
        }
    }
}

android {
    namespace = "io.github.dmitriy1892.kmm.mvvm.compose"
}