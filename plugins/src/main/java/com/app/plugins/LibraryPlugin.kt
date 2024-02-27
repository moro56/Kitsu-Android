@file:Suppress("UnstableApiUsage")

package com.app.gradle

import com.android.build.gradle.BaseExtension
import com.app.plugins.configurations.androidConf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class LibraryPlugin : Plugin<Project> {
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
        }
    }
}