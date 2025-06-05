package de.org.dexterity.ticketsbooking.azmerp01geolocation.infrastructure.primary.beer;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.Beers;
import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;

@Schema(name = "beers", description = "Some beers")
final class RestBeers {

    private final Collection<RestBeer> beers;

    private RestBeers(Collection<RestBeer> beers) {
        this.beers = beers;
    }

    public static RestBeers from(Beers beers) {
        Assert.notNull("beers", beers);

        return new RestBeers(beers.stream().map(RestBeer::from).toList());
    }

    public Collection<RestBeer> getBeers() {
        return beers;
    }
}
