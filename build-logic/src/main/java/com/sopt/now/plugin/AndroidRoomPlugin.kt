package com.sopt.now.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidRoomPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
        dependencies {
            "implementation"(libs.findLibrary("androidx.room.runtime").get())
            "implementation"(libs.findLibrary("androidx.room.ktx").get())
            "kapt"(libs.findLibrary("androidx.room.compiler").get())
        }
    }
}