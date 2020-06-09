# jqwik-multi-engine-maven

Simple examples of how to use [jqwik](https://jqwik.net) together with
JUnit 4 and JUnit 5 Jupiter using Maven.

## Running tests

- In IDE of your choice that has JUnit5 platform support, e.g. IntelliJ IDEA.
- Using gradle: `mvn test`

## Configuration

Jqwik's
[configuration file](https://jqwik.net/docs/current/user-guide.html#jqwik-configuration)
is located in `/src/test/resources/jqwik.properties`

You probably want to add the database name to your `.gitignore` file.
