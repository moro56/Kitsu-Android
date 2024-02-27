@file:Suppress("UnstableApiUsage")

package com.app.plugins

import com.android.build.gradle.BaseExtension
import com.app.plugins.configurations.androidConf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin-android")
                apply("kotlin-kapt")
                apply("org.jlleitschuh.gradle.ktlint")
            }

            configure<KaptExtension> {
                correctErrorTypes = true
            }

            extensions.configure<BaseExtension> {
                androidConf(this)

                buildTypes {
                    getByName("debug") {
                        isDebuggable = true
                    }
                    getByName("release") {
                        isDebuggable = false
                        isMinifyEnabled = true
                    }
                }
            }

            dependencies {
//                add("implementation", project(":core:base"))
//                add("implementation", project(":core:mvi"))
//                add("implementation", project(":core:navigation"))
//                add("testImplementation", project(":core:test"))
//                add("androidTestImplementation", project(":core:test"))
            }
        }
    }
}