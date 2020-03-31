# jqwik-example

Simple examples of how to use [jqwik](https://jqwik.net) with Gradle

## Running tests

- In IDE of your choice that has JUnit5 platform support, e.g. IntelliJ IDEA.
- Using gradle: `./gradlew test`

## Configuration

Jqwik's
[configuration file](https://jqwik.net/docs/current/user-guide.html#jqwik-configuration)
is located in `/src/test/java/resources/jqwik.properties`

You probably want to add the database name to your `.gitignore` file.
