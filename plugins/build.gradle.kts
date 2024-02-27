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
            implementationClass = "com.app.gradle.ApplicationPlugin"
        }
        register("plugin.app.compose") {
            id = "plugin.app.compose"
            implementationClass = "com.app.gradle.ApplicationComposePlugin"
        }
        register("plugin.feature") {
            id = "plugin.feature"
            implementationClass = "com.app.gradle.FeaturePlugin"
        }
        register("plugin.library") {
            id = "plugin.library"
            implementationClass = "com.app.gradle.LibraryPlugin"
        }
        register("plugin.library.compose") {
            id = "plugin.library.compose"
            implementationClass = "com.app.gradle.LibraryComposePlugin"
        }
        register("plugin.hilt") {
            id = "plugin.hilt"
            implementationClass = "com.app.gradle.HiltPlugin"
        }
    }
}
