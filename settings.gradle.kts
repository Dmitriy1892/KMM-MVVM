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
include(":kmm-mvvm-core")
include(":kmm-mvvm-compose")
include(":kmm-mvvm-koin")
