package net.jqwik;

import jakarta.inject.Inject;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.micronaut.JqwikMicronautTest;
import net.jqwik.web.api.Web;
import org.assertj.core.api.Assertions;

@JqwikMicronautTest
class EmailValidatorServiceTest {
    @Inject
    private EmailValidatorService subject;

    @Property(tries = 2)
    @Label("Null or blank emails should fail")
    void failureOnNullOrBlankEmails(@ForAll("invalids") final String email) {
        // when
        boolean result = subject.isValid(email);

        // then
        Assertions.assertThat(result).isFalse();
    }

    @Property(tries = 4)
    @Label("Valid emails should pass")
    void successOnValidEmails(@ForAll("someValid") final String email) {
        // when
        boolean result = subject.isValid(email);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Property(tries = 1)
    @Label("Corner-case emails should fail")
    void failureOnCornerCaseEmails(@ForAll("cornerCases") final String email) {
        // when
        boolean result = subject.isValid(email);

        // then
        Assertions.assertThat(result).isFalse();
    }

    @Provide
    Arbitrary<String> invalids() {
        return Arbitraries.strings().whitespace().injectNull(1.0);
    }

    @Provide
    Arbitrary<String> someValid() {
        return Arbitraries.of("test@test.com", "null@null.com", "null@test.com", "test@null.com");
    }

    @Provide
    Arbitrary<String> cornerCases() {
        // For the sake of simplicity, any email other than the ones in the `someValid` method will be
        // considered a corner case.
        // Adding a suffix here to prevent the random generator from ever generating a "valid" email.
        return Web.emails().map(e -> e + "s");
    }
}