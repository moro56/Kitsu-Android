plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.library")
    id("plugin.hilt")
}

android {
    namespace = "com.app.core.data"
}

dependencies {
    implementation(project(":core:network"))
    testImplementation(project(":core:test"))
}
