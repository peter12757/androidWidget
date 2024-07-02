plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    `maven-publish`
}

group = "com.eathemeat"
version="1.0.0"

android {
    namespace = "com.eathemeat.widget"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        aarMetadata {
            minCompileSdk = 24
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "io.github.peter12757"
            artifactId = "androidWidget"
            version = "1.0.1"

            pom {
                name = "androidWidget"
                description = "A concise description of my library"
                url = "https://github.com/peter12757/androidWidget"
                properties = mapOf(
//                    "myProp" to "value",
//                    "prop.with.dots" to "anotherValue"
                )
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "PeterXi"
                        name = "PeterXi"
                        email = "peter12757@126.com"
                    }
                }
//                scm {
//                    connection = "scm:git:git://example.com/my-library.git"
//                    developerConnection = "scm:git:ssh://example.com/my-library.git"
//                    url = "http://example.com/my-library/"
//                }
            }

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

