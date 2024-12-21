
plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DomainGame"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            implementation(projects.data.game)
            implementation(projects.data.settings)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.bundles.koin.compose)
        }
    }
}