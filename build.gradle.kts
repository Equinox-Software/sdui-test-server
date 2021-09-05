val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
   // application
    kotlin("jvm") version "1.5.21"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.21"
   // id("org.jetbrains.compose") version "1.0.0-alpha1"
}

group = "nyx69"
version = "0.0.1"
/*application {
    mainClass.set("nyx69.ApplicationKt")
}*/

compose.desktop {
    application {
        mainClass = "ApplicationKt"
    }
}

tasks.create("stage") {
    dependsOn("installDist")
}

repositories {
    mavenCentral()
  //  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-auth-jwt:$ktor_version")
    implementation("io.ktor:ktor-server-sessions:$ktor_version")
    implementation("io.ktor:ktor-locations:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-server-cio:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")

/*    implementation(compose.web.core)
    implementation(compose.runtime)
    implementation(compose.desktop.currentOs)

 */
}
