package de.org.dexterity.ticketsbooking.shared.kipe.application;

import org.springframework.security.core.Authentication;

public interface AccessContext<T> {
    Authentication authentication();

    String action();

    T element();

    static <T> AccessContext<T> of(Authentication authentication, String action, T element) {
        return AccessContextFactory.of(authentication, action, element);
    }
}
