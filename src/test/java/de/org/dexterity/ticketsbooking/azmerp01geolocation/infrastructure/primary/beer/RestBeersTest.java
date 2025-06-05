package de.org.dexterity.ticketsbooking.azmerp01geolocation.infrastructure.primary.beer;

import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.JsonHelper;
import de.org.dexterity.ticketsbooking.UnitTest;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.Beers;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeersFixture;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class RestBeersTest {

    @Test
    void shouldSerializeToJson() {
        assertThat(JsonHelper.writeAsString(RestBeers.from(new Beers(List.of(BeersFixture.beer()))))).isEqualTo(json());
    }

    private String json() {
        return "{\"beers\":[" + RestBeerTest.json() + "]}";
    }
}
