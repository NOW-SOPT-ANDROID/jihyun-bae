package com.sopt.now.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

internal class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins.apply("com.android.library")
        configureAndroidCommonPlugin()
    }
}