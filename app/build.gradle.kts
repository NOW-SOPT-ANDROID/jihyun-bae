plugins {
    alias(libs.plugins.sopt.android.application)
    alias(libs.plugins.sopt.android.test)
    alias(libs.plugins.sopt.android.hilt)
}

android {
    namespace = "com.sopt.now"

    defaultConfig {
        applicationId = "com.sopt.now"
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(project(":feature"))
    implementation(project(":core-designsystem"))
    implementation(project(":core-ui"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":data-local"))
    implementation(project(":data-remote"))

    // Third Party
    implementation(libs.bundles.retrofit)
}