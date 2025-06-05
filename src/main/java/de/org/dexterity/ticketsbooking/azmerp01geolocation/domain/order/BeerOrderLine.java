package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.order;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.Amount;
import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;

public record BeerOrderLine(OrderedBeer beer, int quantity) {
    public BeerOrderLine {
        Assert.notNull("beer", beer);
        Assert.field("quantity", quantity).min(1);
    }

    Amount amount() {
        return beer().unitPrice().times(quantity());
    }
}
