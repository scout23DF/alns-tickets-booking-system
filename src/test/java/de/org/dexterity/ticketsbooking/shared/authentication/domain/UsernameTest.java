package de.org.dexterity.ticketsbooking.shared.authentication.domain;

import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class UsernameTest {

    @Test
    void shouldGetEmptyUsernameFromNullUsername() {
        assertThat(Username.of(null)).isEmpty();
    }

    @Test
    void shouldGetEmptyUsernameFromBlankUsername() {
        assertThat(Username.of(" ")).isEmpty();
    }

    @Test
    void shouldGetUsernameFromActualUsername() {
        assertThat(Username.of("user")).contains(new Username("user"));
    }

    @Test
    void shouldGetUsername() {
        assertThat(new Username("user").get()).isEqualTo("user");
    }
}
