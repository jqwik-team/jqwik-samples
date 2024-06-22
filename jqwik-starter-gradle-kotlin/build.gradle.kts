import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.0"
}

repositories {
    mavenCentral()
    // Only necessary if you use jqwik's SNAPSHOT releases:
    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    testImplementation("net.jqwik:jqwik:1.9.0-SNAPSHOT")
    testImplementation("net.jqwik:jqwik-kotlin:1.9.0-SNAPSHOT")
    testImplementation("org.assertj:assertj-core:3.26.0")

    // Optional but recommended to get annotation related API warnings, e.g. for @CheckReturnValue
    compileOnly("org.jspecify:jspecify:0.3.0")
    compileOnly("com.google.errorprone:error_prone_annotations:2.28.0")
}

tasks.withType<Test> {
    useJUnitPlatform()

    // To allow other naming conventions
    include("**/*Properties.class")
    include("**/*Examples.class")
    include("**/*Test.class")
    include("**/*Tests.class")
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs = listOf(
            "-Xnullability-annotations=@org.jspecify.annotations:strict",
            "-Xemit-jvm-type-annotations" // Enable annotations on type variables
        )
        apiVersion = org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0
        languageVersion = org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0
        javaParameters = true // Get correct parameter names in jqwik reporting
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.7"
}
