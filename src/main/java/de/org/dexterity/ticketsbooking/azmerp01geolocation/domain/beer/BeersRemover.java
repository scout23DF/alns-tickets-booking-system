package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeerId;
import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;

public class BeersRemover {

    private final BeersRepository beers;

    public BeersRemover(BeersRepository beers) {
        Assert.notNull("beers", beers);

        this.beers = beers;
    }

    public void remove(BeerId id) {
        Assert.notNull("id", id);

        Beer beer = beers.get(id).orElseThrow(() -> new UnknownBeerException(id));

        beer.removeFromSell();
        beers.save(beer);
    }
}
