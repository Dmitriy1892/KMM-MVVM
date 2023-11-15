plugins {
    id("multiplatform-compose-setup")
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "SampleSDK"
            transitiveExport = false
            isStatic = true
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

        iosMain {
            dependencies {
                api(project(":mvvm-core"))
                api(project(":mvvm-compose"))
                api(project(":mvvm-koin"))
            }
        }
    }
}

android {
    namespace = "io.github.dmitriy1892.kmm.sample"
}