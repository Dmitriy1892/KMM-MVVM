plugins {
    id("multiplatform-setup")
    kotlin("native.cocoapods")

    id("publication-settings")
    id("maven-publish")
}

group = "io.github.dmitriy1892.kmm"
version = libs.versions.kmm.mvvm.get()

kotlin {

    android {
        publishLibraryVariants("release", "debug")
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        podfile = project.file("../iosApp/Podfile")
        name = "KmmMvvmCore"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "KmmMvvmCore"

            export(libs.kmm.utils)
        }
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
            }
        }
    }
}

android {
    namespace = "com.coldfier.kmm.mvvm.core"
}