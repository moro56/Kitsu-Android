plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.library")
    id("plugin.library.compose")
}

android {
    namespace = "com.app.ui"
}

dependencies {
    implementation(project(":core:base"))
    implementation(project(":core:navigation"))
}
