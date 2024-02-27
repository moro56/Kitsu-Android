@file:Suppress("UnstableApiUsage")

package com.app.gradle

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.app.plugins.configurations.composeConf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class ApplicationComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType<BaseAppModuleExtension>()
            composeConf(extension)
        }
    }
}
