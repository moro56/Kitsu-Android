pluginManagement {
    includeBuild("plugins")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Kitsu-Android"
include(":app")
include(":core:base")
include(":core:navigation")
include(":core:network")
include(":core:local")
include(":core:data")
include(":core:test")
include(":core:ui")
include(":features:anime")
include(":features:manga")
include(":features:categories")
