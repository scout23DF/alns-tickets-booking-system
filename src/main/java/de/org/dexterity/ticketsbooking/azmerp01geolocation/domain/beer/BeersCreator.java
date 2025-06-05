package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer;

import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;

public class BeersCreator {

    private final BeersRepository beers;

    public BeersCreator(BeersRepository beers) {
        Assert.notNull("beers", beers);

        this.beers = beers;
    }

    public Beer create(BeerToCreate beerToCreate) {
        var createdBeer = beerToCreate.create();

        beers.save(createdBeer);

        return createdBeer;
    }
}
