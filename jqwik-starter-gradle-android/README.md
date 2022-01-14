# jqwik-starter-gradle-android

Simple examples of how to use [jqwik](https://jqwik.net) with Gradle, Android and Kotlin.

Mind that jqwik only works with a full-blown JDK and not with an Android Runtime.

## Running tests

- In IDE of your choice that has JUnit5 platform support, e.g. IntelliJ IDEA.
- Using gradle: `./gradlew test`

## Configuration

Jqwik's
[configuration file](https://jqwik.net/docs/current/user-guide.html#jqwik-configuration)
is located in `/src/test/resources/junit-platform.properties`

You also have to set up your local Android SDK and configure it in a `local.properties` file.

You probably want to add the database name (default is `jqwik-database`)
to your `.gitignore` file.
