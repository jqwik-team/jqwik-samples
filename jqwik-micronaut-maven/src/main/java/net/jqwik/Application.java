package net.jqwik;

import io.micronaut.runtime.Micronaut;

public class Application {
    public static void main(final String... args) {
        Micronaut.run(Application.class, args);
    }
}