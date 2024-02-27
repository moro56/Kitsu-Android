plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.app")
    id("plugin.app.compose")
    id("plugin.hilt")
}

android {
    namespace = "com.app.modular"
}

ktlint {
    android.set(true)
    outputColorName.set("RED")
}

dependencies {
}
