plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.library")
    id("plugin.hilt")
    id("kotlin-kapt")
}

android {
    namespace = "com.app.core.local"
}

dependencies {
    testImplementation(project(":core:test"))

    // Room
    api(libs.bundles.room)
    kapt(libs.room.compiler)

    // Paging
    api(libs.bundles.paging)
}
