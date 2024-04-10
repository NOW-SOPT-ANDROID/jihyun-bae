plugins {
    alias(libs.plugins.sopt.android.library)
    alias(libs.plugins.sopt.android.test)
}

android {
    namespace = "com.sopt.now.data"
}

dependencies {
    implementation(project(":domain"))

    // Third Party
    implementation(libs.bundles.retrofit)
}