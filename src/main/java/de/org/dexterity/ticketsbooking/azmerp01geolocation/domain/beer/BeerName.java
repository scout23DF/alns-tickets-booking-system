package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer;

import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;

public record BeerName(String name) {
    public BeerName {
        Assert.field("name", name).notBlank().maxLength(255);
    }

    public String get() {
        return name();
    }
}
