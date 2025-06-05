package de.org.dexterity.ticketsbooking.azmerp01geolocation.application;

import de.org.dexterity.ticketsbooking.shared.kipe.domain.Resource;

enum BeerResource implements Resource {
    BEERS("beers");

    private final String key;

    BeerResource(String key) {
        this.key = key;
    }

    @Override
    public String key() {
        return key;
    }
}
