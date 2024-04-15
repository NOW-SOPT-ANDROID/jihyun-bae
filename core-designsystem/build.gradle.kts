plugins {
    alias(libs.plugins.sopt.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "org.sopt.now.designsystem"
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core-ui"))
}
