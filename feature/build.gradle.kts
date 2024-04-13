plugins {
    alias(libs.plugins.sopt.android.library)
    alias(libs.plugins.sopt.android.test)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.sopt.now.feature"
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core-designsystem"))
    implementation(project(":core-ui"))
    implementation(project(":domain"))

    implementation(libs.bundles.androidx)

    // Google
    implementation(libs.google.material)

    // Coil
    implementation(libs.coil)
    implementation(libs.activity)
}