package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer;

import static de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeersIdentityFixture.*;

public final class BeersFixture {

    private BeersFixture() {}

    public static Beer beer() {
        return Beer.builder()
            .id(cloackOfFeathersId())
            .name(cloakOfFeathersName().get())
            .unitPrice(cloakOfFeatherUnitPrice().get())
            .sellingState(BeerSellingState.SOLD)
            .build();
    }

    public static BeerToCreate beerToCreate() {
        return new BeerToCreate(cloakOfFeathersName(), cloakOfFeatherUnitPrice());
    }

    private static BeerName cloakOfFeathersName() {
        return new BeerName("Cloak of feathers");
    }
}
