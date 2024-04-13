plugins {
    alias(libs.plugins.sopt.android.library)
    alias(libs.plugins.sopt.android.test)
}

android {
    namespace = "com.sopt.now.data.local"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":data"))
}
