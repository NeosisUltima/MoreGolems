@file:Suppress("PropertyName")

import java.util.Date

val modId: String = (rootProject.findProperty("modBaseName")!! as String).toLowerCase()
val DEBUGGING_EXTRA = false

plugins {
    id("net.minecraftforge.gradle") version "3.0.161"
    id("eclipse")
    id("maven-publish")
}

group = rootProject.findProperty("modGroup") as String
version = rootProject.findProperty("modVersion") as String

base {
    archivesBaseName = modId
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
//sourceCompatibility = targetCompatibility = compileJava.sourceCompatibility = compileJava.targetCompatibility = "1.8" // Need this here so eclipse task generates correctly.

repositories {
    jcenter()
    maven("https://minecraft.curseforge.com/api/maven/") {
        name = "CurseForge"
    }
}

dependencies {
    minecraft("net.minecraftforge:forge:1.15.2-31.1.0")
}

minecraft {

    mappingChannel = "snapshot"
    mappingVersion = "20200215-1.15.1"

    runs {
        listOf("client","server").forEach {
            create(it) {

                // Specify the working directory to run the build type
                workingDirectory = file("run").absolutePath

                if(DEBUGGING_EXTRA)
                {
                    // Extra logging levels for the console
                    property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
                    property("forge.logging.console.level", "debug")
                }
                else
                {
                    // Less logging levels for the console
                    property("forge.logging.markers", "SCAN")
                    property("forge.logging.console.level", "info")
                }

                mods {
                    create(modId) {
                        source( sourceSets.main.get() )
                    }
                }
                ideaModule = "${project.name}.main"
            }
        }
        create("data") {
            // Specify the working directory to run the build type
            workingDirectory = file("run").absolutePath

            if(DEBUGGING_EXTRA)
            {
                // Extra logging levels for the console
                property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
                property("forge.logging.console.level", "debug")
            }
            else
            {
                // Less logging levels for the console
                property("forge.logging.markers", "SCAN")
                property("forge.logging.console.level", "info")
            }

            args("--mod", modId, "--all", "--output", file("src/generated/resources/") )

            mods {
                create(modId) {
                    source( sourceSets.main.get() )
                }
            }
            ideaModule = "${project.name}.main"

        }
    }
}

tasks.jar {
    manifest.attributes(
            "Specification-Title" to "examplemod",
            "Specification-Vendor" to "examplemodsareus",
            "Specification-Version" to "1",
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version,
            "Implementation-Vendor" to "examplemodsareus",
            "Implementation-Timestamp" to Date()  //.format("yyyy-MM-dd'T'HH:mm:ssZ")
    )
}