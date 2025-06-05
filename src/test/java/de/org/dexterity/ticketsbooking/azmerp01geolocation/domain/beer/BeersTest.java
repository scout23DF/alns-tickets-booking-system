package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer;

import static de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeersIdentityFixture.*;
import static de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeersFixture.*;
import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class BeersTest {

    @Test
    void shouldSortBeersByNames() {
        Beer anteMeridiem = Beer.builder()
            .id(anteMeridiemId())
            .name(new BeerName("Ante Meridiem"))
            .unitPrice(anteMeridiemUnitPrice())
            .sellingState(BeerSellingState.SOLD)
            .build();

        var beers = new Beers(List.of(beer(), anteMeridiem));

        assertThat(beers.get()).usingRecursiveFieldByFieldElementComparator().containsExactly(anteMeridiem, beer());
    }
}
