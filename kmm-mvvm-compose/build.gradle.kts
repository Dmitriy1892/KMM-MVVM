plugins {
    id("multiplatform-compose-setup")
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
        name = "KmmMvvmCompose"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "KmmMvvmCompose"
        }
    }
    
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":kmm-mvvm-core"))
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.lifecycle.compose.viewmodel)
            }
        }
    }
}

android {
    namespace = "com.coldfier.kmm.mvvm.compose"
}