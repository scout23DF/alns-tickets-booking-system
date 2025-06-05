package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.Amount;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeerId;
import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;

public record BeerToCreate(BeerName name, Amount unitPrice) {
    public BeerToCreate {
        Assert.notNull("name", name);
        Assert.notNull("unitPrice", unitPrice);
    }

    public Beer create() {
        return Beer.builder().id(BeerId.newId()).name(name()).unitPrice(unitPrice()).sellingState(BeerSellingState.SOLD).build();
    }
}
