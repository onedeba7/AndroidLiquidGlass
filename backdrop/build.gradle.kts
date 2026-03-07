plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "com.github.debacodex.backdrop"
    compileSdk = 36

    defaultConfig {
       
        minSdk = 21
        targetSdk = 36
      

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }
////

publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
        // If you need to publish multiple variants:
        // singleVariant("debug") {
        //     withSourcesJar()
        // }
    }

///
    
}
kotlin {
    jvmToolchain(17)
    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xcontext-parameters"
        )
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.debacodex.shapes)
}

// After the android block
publishing {
    publications {
        register<MavenPublication>("release") {
            // The coordinates of your library
            groupId = "com.github.onedeba7"
            artifactId = "backdrop"
            version = "1.0.0"

            // Tell Gradle to publish the Android library
            afterEvaluate {
                from(components["release"])
            }

            // Optional: Add custom POM metadata
            pom {
                name.set("My Library")
                description.set("A useful Android library")
                url.set("https://github.com/onedeba7/AndroidLiquidGlass")
                
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                
                developers {
                    developer {
                       // id.set("developerId")
                        name.set("Developer Name")
                        email.set("developer@example.com")
                    }
                }
                
                scm {
                    connection.set("scm:git:git://github.com/onedeba7/AndroidLiquidGlass.git")
                    developerConnection.set("scm:git:ssh://github.com/onedeba7/AndroidLiquidGlass.git")
                    url.set("https://github.com/onedeba7/AndroidLiquidGlass")
                }
            }
        }
    }

    // Configure repositories
    repositories {
        // Local Maven repository (for testing)
        
        
        // Custom repository (e.g., GitHub Packages, private Nexus, etc.)
        maven {
                // GitHub Packages URL structure: 
                // https://maven.pkg.github.com/OWNER/REPOSITORY
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/onedeba7/AndroidLiquidGlass")

                // Get credentials from environment variables for GitHub Actions
                credentials {
                    username = System.getenv("GPR_USER") ?: ""
                    password = System.getenv("GPR_KEY") ?: ""
            }
        }
    }
}