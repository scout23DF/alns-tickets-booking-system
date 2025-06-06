package de.org.dexterity.ticketsbooking.account.infrastructure.primary;

import static de.org.dexterity.ticketsbooking.account.domain.AccountsFixture.*;
import static org.assertj.core.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.org.dexterity.ticketsbooking.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RestAccountTest {

    private static final ObjectMapper json = new ObjectMapper();

    @Test
    void shouldSerializeToJson() throws JsonProcessingException {
        assertThat(json.writeValueAsString(RestAccount.from(account()))).isEqualTo(json());
    }

    private String json() {
        return """
        {\
        "username":"user",\
        "name":"Paul DUPOND",\
        "email":"email@company.fr",\
        "roles":["ROLE_ADMIN"]\
        }\
        """;
    }
}
