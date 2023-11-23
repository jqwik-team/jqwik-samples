import com.github.sormuras.bach.Bach;
import com.github.sormuras.bach.external.JUnit;
import com.github.sormuras.bach.external.Maven;
import com.github.sormuras.bach.simple.SimpleSpace;

class build {

    static final String JUNIT_VERSION = "5.9.1", JQWIK_VERSION = "1.8.2", ASSERTJ_VERSION = "3.24.2";

    public static void main(String... args) {
        try (var bach = new Bach(args)) {
            var grabber = bach.grabber(JUnit.version(JUNIT_VERSION), build::locate);

            bach.logCaption("Compile main module space");
            var main = SimpleSpace.of(bach, "main").withModule("my.example.project");
            main.compile(javac -> javac.add("-Xlint").add("-Werror"), jar -> jar.verbose(true));

            bach.logCaption("Grab external modules and compile test module space");
            var test = main.newDependentSpace("test").withModule("test.my.modules");
            test.grab(grabber, "org.junit.platform.console", "net.jqwik.engine", "org.assertj.core");
            test.compile(javac -> javac.add("-g").add("-parameters"));

            test.runAllTests();
        }
    }

    static String locate(String module) {
        return switch (module) {
            case "net.jqwik.api" -> Maven.central("net.jqwik", "jqwik-api", JQWIK_VERSION);
            case "net.jqwik.engine" -> Maven.central("net.jqwik", "jqwik-engine", JQWIK_VERSION);
            case "org.assertj.core" -> Maven.central("org.assertj", "assertj-core", ASSERTJ_VERSION);
            default -> null;
        };
    }
}
