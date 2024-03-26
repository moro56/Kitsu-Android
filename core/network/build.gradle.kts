plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.library")
    id("plugin.hilt")
}

android {
    namespace = "com.app.core.network"

    defaultConfig {
        buildConfigField("String", "BASE_URL", "\"https://kitsu.io/api/edge/\"")
    }
}

dependencies {
    testImplementation(project(":core:test"))

    // Network
    implementation(libs.bundles.network)
}
