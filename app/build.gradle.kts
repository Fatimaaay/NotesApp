plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp) // Use the new KSP plugin
}

android {
    namespace = "com.example.notesapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.notesapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // ✅ Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler) // Change from kapt to ksp
    implementation(libs.androidx.room.ktx)
    testImplementation(libs.androidx.room.testing)

}