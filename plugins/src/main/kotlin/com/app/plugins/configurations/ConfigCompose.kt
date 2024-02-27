@file:Suppress("UnstableApiUsage")

package com.app.plugins.configurations

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.File

internal fun Project.composeConf(extension: CommonExtension<*, *, *, *>) {
    extension.apply {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose-compiler").get().toString()
        }

        project.tasks.withType(KotlinCompile::class.java).configureEach {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + buildComposeMetricsParameters()
            }
        }

        dependencies {
            val bom = libs.findLibrary("compose-bom").get()
            val compose = libs.findBundle("compose").get()
            val composeTooling = libs.findLibrary("compose-ui-tooling").get()

            add("implementation", platform(bom))
            add("implementation", compose)
            add("debugImplementation", composeTooling)

            val test = libs.findBundle("test").get()
            val androidTest = libs.findBundle("android-test").get()
            val composeTest = libs.findLibrary("ui-test-junit4").get()
            val composeManifest = libs.findLibrary("ui-test-manifest").get()

            add("implementation", compose)
            add("testImplementation", test)
            add("testImplementation", platform(bom))
            add("testImplementation", composeTest)
            add("androidTestImplementation", androidTest)
            add("androidTestImplementation", platform(bom))
            add("androidTestImplementation", composeTest)
            add("debugImplementation", composeManifest)
        }
    }
}

private fun Project.buildComposeMetricsParameters(): List<String> {
    val metricParameters = mutableListOf<String>()
    val enableMetricsProvider = project.providers.gradleProperty("enableMetrics")
    val enableMetrics = (enableMetricsProvider.orNull == "true")
    if (enableMetrics) {
        val metricsFolder = File(project.buildDir, "compose-metrics")
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + metricsFolder.absolutePath
        )

        val reportsFolder = File(project.buildDir, "compose-reports")
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + reportsFolder.absolutePath
        )
    }
    return metricParameters.toList()
}
