plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.library")
    id("plugin.hilt")
}

android {
    namespace = "com.app.core.data"

    defaultConfig {
        buildConfigField("int", "PAGING_LIMIT", "20")
        buildConfigField("int", "PAGING_PREFETCH_DISTANCE", "9")
    }
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:local"))
    testImplementation(project(":core:test"))
}
