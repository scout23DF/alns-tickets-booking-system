package de.org.dexterity.ticketsbooking.shared.kipe.application;

import de.org.dexterity.ticketsbooking.shared.authentication.domain.Role;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

public final class TestAuthentications {

    private TestAuthentications() {}

    public static Authentication admin() {
        return new TestingAuthenticationToken("admin", null, Role.ADMIN.key());
    }

    public static Authentication user() {
        return user("user");
    }

    public static TestingAuthenticationToken user(String username) {
        return new TestingAuthenticationToken(username, null, Role.USER.key());
    }
}
