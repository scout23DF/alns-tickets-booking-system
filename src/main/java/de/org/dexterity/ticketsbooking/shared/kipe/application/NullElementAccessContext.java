package de.org.dexterity.ticketsbooking.shared.kipe.application;

import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;
import de.org.dexterity.ticketsbooking.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import org.springframework.security.core.Authentication;

@ExcludeFromGeneratedCodeCoverage(reason = "Untested null object structure")
record NullElementAccessContext<T>(Authentication authentication, String action) implements AccessContext<T> {
    public NullElementAccessContext {
        Assert.notNull("authentication", authentication);
        Assert.notBlank("action", action);
    }

    @Override
    public T element() {
        return null;
    }
}
