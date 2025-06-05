package de.org.dexterity.ticketsbooking.azmerp01geolocation.infrastructure.secondary;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeerSellingState;
import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaBeersRepository extends JpaRepository<BeerEntity, UUID> {
    Collection<BeerEntity> findBySellingState(BeerSellingState sellingState);
}
