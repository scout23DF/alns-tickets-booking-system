package de.org.dexterity.ticketsbooking.azmerp01geolocation.infrastructure.secondary;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeerId;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.Beer;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeerSellingState;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.Beers;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeersRepository;
import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
class SpringDataBeersRepository implements BeersRepository {

    private final JpaBeersRepository beers;

    public SpringDataBeersRepository(JpaBeersRepository beers) {
        this.beers = beers;
    }

    @Override
    public void save(Beer beer) {
        Assert.notNull("beer", beer);

        beers.save(BeerEntity.from(beer));
    }

    @Override
    public Beers catalog() {
        return new Beers(beers.findBySellingState(BeerSellingState.SOLD).stream().map(BeerEntity::toDomain).toList());
    }

    @Override
    public Optional<Beer> get(BeerId beer) {
        Assert.notNull("beer", beer);

        return beers.findById(beer.get()).map(BeerEntity::toDomain);
    }
}
