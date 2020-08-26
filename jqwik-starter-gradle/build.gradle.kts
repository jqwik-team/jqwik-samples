plugins {
    id("java")
}

val jqwikVersion: String by project
val assertJVersion: String by project
val junitJupiterVersion: String by project
val junitPlatformVersion: String by project

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
	compileTestJava {
		options.compilerArgs.add("-parameters")
		options.encoding = "UTF-8"
	}

	test {
		useJUnitPlatform()

        // To allow other naming conventions
        include ("**/*Properties.class")
        include ("**/*Examples.class")
        include ("**/*Test.class")
        include ("**/*Tests.class")
    }

    wrapper {
        description = "Generates gradlew[.bat] scripts"
        gradleVersion = "6.6.1"
    }
}

dependencies {
    testImplementation("net.jqwik:jqwik:${jqwikVersion}")

    // Fluent assertions library. You can use any other assertions instead.
    testImplementation("org.assertj:assertj-core:${assertJVersion}")

    // To work around IntelliJ bug to not provide run test decorator
    // https://youtrack.jetbrains.com/issue/IDEA-231482
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitJupiterVersion}")
}

