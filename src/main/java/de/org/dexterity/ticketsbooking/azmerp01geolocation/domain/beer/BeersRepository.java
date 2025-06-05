package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeerId;
import java.util.Optional;

public interface BeersRepository {
    void save(Beer beer);

    Beers catalog();

    Optional<Beer> get(BeerId beer);
}
