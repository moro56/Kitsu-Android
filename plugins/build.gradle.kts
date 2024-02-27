plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.gradle.tools)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("plugin.app") {
            id = "plugin.app"
            implementationClass = "com.app.plugins.ApplicationPlugin"
        }
        register("plugin.app.compose") {
            id = "plugin.app.compose"
            implementationClass = "com.app.plugins.ApplicationComposePlugin"
        }
        register("plugin.feature") {
            id = "plugin.feature"
            implementationClass = "com.app.plugins.FeaturePlugin"
        }
        register("plugin.library") {
            id = "plugin.library"
            implementationClass = "com.app.plugins.LibraryPlugin"
        }
        register("plugin.library.compose") {
            id = "plugin.library.compose"
            implementationClass = "com.app.plugins.LibraryComposePlugin"
        }
        register("plugin.hilt") {
            id = "plugin.hilt"
            implementationClass = "com.app.plugins.HiltPlugin"
        }
    }
}
