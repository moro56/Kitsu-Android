package com.app.plugins.configurations

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("UnstableApiUsage")
internal fun Project.androidConf(extension: BaseExtension) {
    extension.apply {
        compileSdkVersion(34)

        defaultConfig {
            minSdk = 26
            targetSdk = 34

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        buildFeatures.buildConfig = true

        project.tasks.withType(KotlinCompile::class.java).configureEach {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
                freeCompilerArgs = listOf(
                    "-Xstring-concat=inline",
                    "-Xlint:deprecation",
                    "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
                    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
                )
            }
        }

        packagingOptions.setExcludes(
            mutableSetOf(
                "META-INF/**",
                "LICENSE.txt",
                "LICENSE"
            )
        )

        testOptions {
            unitTests {
                isIncludeAndroidResources = true
                isReturnDefaultValues = true
            }
        }
    }
}