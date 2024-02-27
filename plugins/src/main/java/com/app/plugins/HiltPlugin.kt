@file:Suppress("UnstableApiUsage")

package com.app.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class HiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("dagger.hilt.android.plugin")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                val hilt = libs.findLibrary("hilt").get()
                val hiltNavigation = libs.findLibrary("hilt-navigation").get()
                val lifecycleViewModel = libs.findLibrary("lifecycle-viewmodel-ktx").get()
                val hiltKapt = libs.findLibrary("hilt-kapt").get()
                val hiltTest = libs.findLibrary("hilt-test").get()

                add("implementation", hilt)
                add("implementation", hiltNavigation)
                add("implementation", lifecycleViewModel)
                add("kapt", hiltKapt)
                add("testImplementation", hiltTest)
                add("kaptTest", hiltKapt)
                add("androidTestImplementation", hiltTest)
                add("kaptAndroidTest", hiltKapt)
            }
        }
    }
}
