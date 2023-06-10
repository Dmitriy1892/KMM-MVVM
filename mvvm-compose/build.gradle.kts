plugins {
    id("multiplatform-compose-setup")
    kotlin("native.cocoapods")

    id("publication-settings")
    id("maven-publish")
}

group = "io.github.dmitriy1892.kmm"
version = getMyLibraryVersion()

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
        ios.deploymentTarget = libs.versions.iosTargetVersion.get()
        framework {
            baseName = "KmmMvvmCompose"
        }
    }
    
    sourceSets {
        commonMain {
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