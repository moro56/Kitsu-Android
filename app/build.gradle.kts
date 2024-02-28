plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.app")
    id("plugin.app.compose")
    id("plugin.hilt")
}

android {
    namespace = "com.app.kitsu"
}

ktlint {
    android.set(true)
    outputColorName.set("RED")
}

dependencies {
    implementation(project(":features:anime"))
    implementation(project(":features:manga"))
    implementation(project(":features:categories"))
}
