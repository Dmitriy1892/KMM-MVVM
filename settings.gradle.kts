pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KMM-MVVM"

include(":androidApp")
include(":mvvm-core")
include(":mvvm-compose")
include(":mvvm-koin")
include(":sample")
