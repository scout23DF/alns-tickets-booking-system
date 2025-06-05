package de.org.dexterity.ticketsbooking.azmerp01geolocation.infrastructure.primary.beer;

import static de.org.dexterity.ticketsbooking.BeanValidationAssertions.*;
import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.JsonHelper;
import de.org.dexterity.ticketsbooking.UnitTest;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeersFixture;
import org.junit.jupiter.api.Test;

@UnitTest
class RestBeerToCreateTest {

    @Test
    void shouldDeserializeFromJson() {
        assertThat(JsonHelper.readFromJson(json(), RestBeerToCreate.class).toDomain())
            .usingRecursiveComparison()
            .isEqualTo(BeersFixture.beerToCreate());
    }

    private String json() {
        return """
        {
          "name": "Cloak of feathers",
          "unitPrice": 8.53
        }
        """;
    }

    @Test
    void shouldNotValidateEmptyBean() {
        assertThatBean(new RestBeerToCreate(null, null)).hasInvalidProperty("name").and().hasInvalidProperty("unitPrice");
    }
}
