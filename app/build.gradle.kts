plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.hilt.get().pluginId)
    kotlin("kapt")
}

android {
    namespace = "id.ak.multimoduletemplate"
    compileSdk = 35

    defaultConfig {
        applicationId = "id.ak.multimoduletemplate"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
    implementation(libs.androidx.multidex)

    // Hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.viewmodel)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
}