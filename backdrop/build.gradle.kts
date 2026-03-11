plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.android.library)
    id("com.vanniktech.maven.publish")
}
//apply(from = "publish.gradle.kts")

android {
    namespace = "com.kyant.backdrop"
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
    implementation("io.github.onedeba7:shapes:1.0.1")
}

mavenPublishing {
  coordinates("io.github.onedeba7", "backdrop", "1.0.0")
  
  
  pom {
    name.set("AndroidLiquidGlass")
    description.set("Compose Liquid Glass effects.")
    inceptionYear.set("2026")
    url.set("https://github.com/onedeba7/AndroidLiquidGlass/")
    licenses {
      license {
        name.set("The Apache License, Version 2.0")
        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
      }
    }
    developers {
      developer {
        id.set("onedeba7")
        name.set("Debacodex")
        url.set("https://github.com/AndroidLiquidGlass/")
      }
    }
    scm {
      url.set("https://github.com/username/mylibrary/")
      connection.set("scm:git:git://github.com/onedeba7/AndroidLiquidGlass.git")
      developerConnection.set("scm:git:ssh://git@github.com/onedeba7/AndroidLiquidGlass.git")
    }
   }
  
 }
 