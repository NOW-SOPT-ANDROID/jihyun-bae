plugins {
    alias(libs.plugins.sopt.android.library)
    alias(libs.plugins.sopt.android.test)
}

android {
    namespace = "com.sopt.now.data"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data-local"))
    implementation(project(":data-remote"))

    // Third Party
    implementation(libs.bundles.retrofit)
}