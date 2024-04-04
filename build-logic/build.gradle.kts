plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

group = "com.sopt.now.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        create("android-application") {
            id = "com.sopt.now.application"
            implementationClass = "com.sopt.now.plugin.AndroidApplicationPlugin"
        }
        create("android-feature") {
            id = "com.sopt.now.feature"
            implementationClass = "com.sopt.now.plugin.AndroidFeaturePlugin"
        }
        create("android-hilt") {
            id = "com.sopt.now.hilt"
            implementationClass = "com.sopt.now.plugin.AndroidHiltPlugin"
        }
        create("android-kotlin") {
            id = "com.sopt.now.kotlin"
            implementationClass = "com.sopt.now.plugin.AndroidKotlinPlugin"
        }
        create("android-test") {
            id = "com.sopt.now.test"
            implementationClass = "com.sopt.now.plugin.AndroidTestPlugin"
        }
        create("kotlin-serialization") {
            id = "com.sopt.now.serialization"
            implementationClass = "com.sopt.now.plugin.KotlinSerializationPlugin"
        }
    }
}