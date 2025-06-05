package de.org.dexterity.ticketsbooking.shared.kipe.domain;

import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;

public record Action(String action) {
    public Action {
        Assert.notBlank("action", action);
    }

    @Override
    public String toString() {
        return action();
    }
}
