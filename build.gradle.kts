plugins {
    id("com.github.ben-manes.versions").version("0.39.0")
}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.1")
        classpath(Deps.Kotlin.plugin)
        classpath(Deps.Compose.plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    afterEvaluate {
        project.extensions.findByType<org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension>()?.apply {
            sourceSets.removeAll { it.name == "androidAndroidTestRelease" }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "11"
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
