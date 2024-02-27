plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.library")
    id("plugin.library.compose")
    id("plugin.hilt")
}

android {
    namespace = "com.app.core.navigation"
}

dependencies {
    testImplementation(project(":core:test"))
}
