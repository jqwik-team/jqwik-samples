package net.jqwik;

import jakarta.inject.Singleton;

import java.util.regex.Pattern;

@Singleton
class EmailValidatorService {
    // Limited regex that should match four cases only:
    // null@null.mydomain, null@test.mydomain, test@null.mydomain, test@test.mydomain
    private static final String owaspEmailRegex = "(null|test)@(null|test)\\.com";
    private static final Pattern emailPattern = Pattern.compile(owaspEmailRegex);

    public boolean isValid(final String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return emailPattern.matcher(email).matches();
    }
}
