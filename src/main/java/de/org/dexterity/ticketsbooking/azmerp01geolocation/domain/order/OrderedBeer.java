package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.order;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.Amount;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeerId;
import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;

public record OrderedBeer(BeerId beer, Amount unitPrice) {
    public OrderedBeer {
        Assert.notNull("beer", beer);
        Assert.notNull("unitPrice", unitPrice);
    }
}
