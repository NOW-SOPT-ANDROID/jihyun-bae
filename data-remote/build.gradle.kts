plugins {
    alias(libs.plugins.sopt.android.library)
    alias(libs.plugins.sopt.android.test)
}

android {
    namespace = "com.sopt.now.data.remote"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    // Third Party
    implementation(libs.bundles.retrofit)
}
