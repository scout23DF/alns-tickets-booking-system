package de.org.dexterity.ticketsbooking.shared.kipe.application;

import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;
import org.springframework.security.core.Authentication;

public record ElementAccessContext<T>(Authentication authentication, String action, T element) implements AccessContext<T> {
    public ElementAccessContext {
        Assert.notNull("authentication", authentication);
        Assert.notBlank("action", action);
        Assert.notNull("element", element);
    }
}
