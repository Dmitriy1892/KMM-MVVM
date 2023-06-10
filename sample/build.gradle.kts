plugins {
    id("multiplatform-compose-setup")
    kotlin("native.cocoapods")
}

kotlin {
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = libs.versions.iosTargetVersion.get()
        podfile = project.file("../iosApp/Podfile")
        name = "SampleSDK"
        framework {
            isStatic = true
            baseName = "SampleSDK"
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":mvvm-core"))
                implementation(project(":mvvm-compose"))
                implementation(project(":mvvm-koin"))

                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.koin.core)
                implementation(libs.koin.annotations)
            }
        }
    }
}

android {
    namespace = "io.github.dmitriy1892.kmm.sample"
}