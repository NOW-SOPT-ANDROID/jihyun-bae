plugins {
    alias(libs.plugins.sopt.android.library)
    alias(libs.plugins.sopt.android.test)
}

android {
    namespace = "com.sopt.now.feature"
}

dependencies {
    implementation(libs.bundles.androidx)

    // Google
    implementation(libs.google.material)

    // Coil
    implementation(libs.coil)
}