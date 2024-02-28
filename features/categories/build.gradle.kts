plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.feature")
    id("plugin.library.compose")
    id("plugin.hilt")
}

android {
    namespace = "com.app.feature.categories"
}

hilt {
    enableAggregatingTask = true
}
