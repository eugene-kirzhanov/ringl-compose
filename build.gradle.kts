plugins {
    id("com.github.ben-manes.versions").version("0.39.0")
}

buildscript {
    val composeVersion = "1.0.0-alpha4-build315"

    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.5.21"))
        classpath("com.android.tools.build:gradle:7.0.1")
        classpath("org.jetbrains.compose:compose-gradle-plugin:$composeVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    afterEvaluate {
        project.extensions.findByType<org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension>()?.let { kmpExt ->
            kmpExt.sourceSets.removeAll { it.name == "androidAndroidTestRelease" }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "11"
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
