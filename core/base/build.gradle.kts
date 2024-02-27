plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinSerialization)
    id("plugin.library")
    id("plugin.library.compose")
}

android {
    namespace = "com.app.core.base"
}

dependencies {
    // Core
    implementation(libs.bundles.lifecycle)
    // Json
    implementation(libs.serialization.json)
}
