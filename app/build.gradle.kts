plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "kr.ac.kumoh.ce.s20220703.s24w1403retrofit"
    compileSdk = 35

    defaultConfig {
        applicationId = "kr.ac.kumoh.ce.s20220703.s24w1403retrofit"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    buildFeatures {
        compose = true
    }
}

dependencies {
    // NOTE: AsyncImage 사용하기 위해 추가
    //implementation("io.coil-kt.coil3:coil-compose:3.0.4")
    implementation(libs.coil.compose)
    //implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.4")
    implementation(libs.coil.network.okhttp)
    // NOTE: Retrofit 사용하기 위해 추가
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    // NOTE: viewModel() 사용하기 위해 추가
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // NOTE: observeAsState 사용하기 위해 추가
    implementation(libs.androidx.runtime.livedata)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}