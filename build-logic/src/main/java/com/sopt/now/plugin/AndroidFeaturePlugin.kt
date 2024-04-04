package com.sopt.now.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class AndroidFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin-parcelize")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "implementation"(libs.findLibrary("core.ktx").get())
                "implementation"(libs.findLibrary("appcompat").get())
                "implementation"(libs.findLibrary("constraintlayout").get())
                "implementation"(libs.findLibrary("navigation.fragment.ktx").get())

                "implementation"(libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
                "implementation"(libs.findLibrary("androidx.lifecycle.viewmodel.ktx").get())
                "implementation"(libs.findLibrary("androidx.activity.ktx").get())
                "implementation"(libs.findLibrary("androidx.fragment.ktx").get())
                "implementation"(libs.findLibrary("androidx.recyclerview").get())
                "implementation"(libs.findLibrary("google.material").get())

                "implementation"(libs.findLibrary("kotlinx.coroutines.android").get())
                "implementation"(libs.findLibrary("kotlinx.coroutines.core").get())

                "implementation"(libs.findLibrary("timber").get())
            }
        }
    }
}