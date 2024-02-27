plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.library")
}

android {
    namespace = "com.app.core.test"
}

dependencies {
    compileOnly(libs.bundles.test)
}
