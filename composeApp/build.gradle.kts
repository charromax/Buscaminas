import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

val versionPropertiesInputStream = FileInputStream("${rootDir}/versions.properties")
val versionProperties = Properties().apply {
    load(versionPropertiesInputStream)
}

val versionCodeProp = versionProperties.getProperty("versionCode").toInt()
val versionMajorProp = versionProperties.getProperty("versionMajor").toInt()
val versionMinorProp = versionProperties.getProperty("versionMinor").toInt()
val versionPatchProp = versionProperties.getProperty("versionPatch").toInt()

val versionNameProp = "$versionMajorProp.$versionMinorProp.$versionPatchProp"
kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { target ->
        target.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            // Modules
            implementation(projects.ui.core)
            implementation(projects.data.core)
            implementation(projects.feature.menu)
            implementation(projects.feature.settings)
            implementation(projects.feature.play)
            implementation(projects.feature.highscore)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.bundles.koin.compose)

            // Datastore
            implementation(libs.datastore.preferences.core)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "com.charr0max.buscaminas"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.charr0max.buscaminas"
        minSdk = libs.versions.android.minSdk.get().toInt()
        versionCode = versionCodeProp
        versionName = versionNameProp
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }


    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "com.charr0max.buscaminas.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Buscaminas"
            packageVersion = versionNameProp
            description = "Buscaminas by charr0max"
            copyright = "(C) 2025 charr0max"
            licenseFile.set(project.file("../LICENSE"))

            macOS {
                bundleID = "com.charr0max.buscaminas.Buscaminas"
                dockName = "Buscaminas"
                entitlementsFile.set(project.file("defaults.entitlements"))
            }
        }

        buildTypes.release {
            proguard {
                obfuscate.set(true)
                configurationFiles.from("proguard-rules.pro")
            }
        }

    }
}
