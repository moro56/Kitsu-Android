plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.library")
    id("plugin.hilt")
}

android {
    namespace = "com.app.core.network"
}

dependencies {
    implementation(libs.bundles.network)
    testImplementation(project(":core:test"))
}
