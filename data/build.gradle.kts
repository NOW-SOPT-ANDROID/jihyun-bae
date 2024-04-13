plugins {
    alias(libs.plugins.sopt.android.library)
    alias(libs.plugins.sopt.android.test)
}

android {
    namespace = "com.sopt.now.data"
}

dependencies {
    implementation(project(":domain"))

    // DataStore
    implementation(libs.androidx.datastore.preferences)

    // Third Party
    implementation(libs.bundles.retrofit)
}