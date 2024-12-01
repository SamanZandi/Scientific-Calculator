plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
   id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.zandroid.mycalculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.zandroid.mycalculator"
        minSdk = 23
        targetSdk = 34
        versionCode = 11
        versionName = "4.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources=true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding=true
        buildConfig=true
    }

    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Math
    implementation ("net.objecthunter:exp4j:0.4.8")
    implementation("org.mariuszgromada.math:MathParser.org-mXparser:6.1.0")

    //Dagger - Hilt
   implementation ("com.google.dagger:hilt-android:2.51.1")
    kapt ("com.google.dagger:hilt-compiler:2.51.1")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")

    //Room components
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    //annotationProcessor ("androidx.room:room-compiler:2.6.0-rc01")

    //Extensions and coroutines for room
    implementation ("androidx.room:room-ktx:2.6.1")

    //Lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")
    

    //ViewModel
    implementation("androidx.activity:activity-ktx:1.9.3")


    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    //Image Loading
    implementation ("io.coil-kt:coil:2.6.0")

    //Other
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.github.MrNouri:DynamicSizes:1.0")
    implementation ("com.github.fornewid:neumorphism:0.3.2")
}