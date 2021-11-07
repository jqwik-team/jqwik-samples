import com.github.sormuras.bach.Bach;
import com.github.sormuras.bach.external.JUnit;
import com.github.sormuras.bach.external.Maven;
import com.github.sormuras.bach.simple.SimpleSpace;

class build {

    static final String JUNIT_VERSION = "5.8.1", JQWIK_VERSION = "1.6.0-SNAPSHOT", ASSERTJ_VERSION = "3.21.0";

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
            case "net.jqwik.api" -> "https://oss.sonatype.org/content/repositories/snapshots/net/jqwik/jqwik-api/1.6.0-SNAPSHOT/jqwik-api-1.6.0-20211105.114510-41.jar";
            case "net.jqwik.engine" -> "https://oss.sonatype.org/content/repositories/snapshots/net/jqwik/jqwik-engine/1.6.0-SNAPSHOT/jqwik-engine-1.6.0-20211105.114510-39.jar";
            case "org.assertj.core" -> Maven.central("org.assertj", "assertj-core", ASSERTJ_VERSION);
            default -> null;
        };
    }
}
