package de.org.dexterity.ticketsbooking.azmerp01geolocation.infrastructure.secondary;

import static de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeersFixture.*;
import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class BeerEntityTest {

    @Test
    void shouldConvertFromAndToDomain() {
        assertThat(BeerEntity.from(beer()).toDomain()).usingRecursiveComparison().isEqualTo(beer());
    }
}
