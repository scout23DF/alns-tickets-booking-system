package de.org.dexterity.ticketsbooking.azmerp01geolocation.infrastructure.secondary;

import static de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeersIdentityFixture.*;
import static de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeersFixture.*;
import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@IntegrationTest
class JpaBeersRepositoryIT {

    @Autowired
    private JpaBeersRepository beers;

    @Test
    void shouldSaveAndGetBeer() {
        beers.saveAndFlush(BeerEntity.from(beer()));

        assertThat(beers.findById(cloackOfFeathersId().get()).orElseThrow().toDomain()).usingRecursiveComparison().isEqualTo(beer());
    }
}
