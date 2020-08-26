plugins {
//	id ("org.springframework.boot") version "2.2.0.RELEASE"
//	id ("org.springframework.boot") version "2.2.5.RELEASE"
//	id ("org.springframework.boot") version "2.2.6.RELEASE"
	id ("org.springframework.boot") version "2.3.0.RELEASE"
	id ("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("java")
}

val jqwikSpringVersion: String by project
val assertJVersion: String by project
val junitJupiterVersion: String by project
val mockitoVersion: String by project

ext {
	set("mockito.version", mockitoVersion)
	set("assertj.version", assertJVersion)
	set("junit-jupiter.version", junitJupiterVersion)
}


group = "my.example"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
	maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
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
	implementation ("org.springframework.boot:spring-boot-starter-web")
	
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude (group="org.junit.vintage", module="junit-vintage-engine")
	}

	testImplementation("net.jqwik:jqwik-spring:${jqwikSpringVersion}")
}
