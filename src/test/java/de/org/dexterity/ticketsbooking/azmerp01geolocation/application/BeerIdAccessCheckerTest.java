package de.org.dexterity.ticketsbooking.azmerp01geolocation.application;

import static de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeersIdentityFixture.*;
import static de.org.dexterity.ticketsbooking.shared.kipe.application.TestAuthentications.*;
import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import de.org.dexterity.ticketsbooking.shared.kipe.application.AccessContext;
import de.org.dexterity.ticketsbooking.shared.kipe.application.AlnsTicketsBookingSystemAuthorizations;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class BeerIdAccessCheckerTest {

    private static final BeerIdAccessChecker checker = new BeerIdAccessChecker(
        new AlnsTicketsBookingSystemAuthorizations(List.of(new BeersAccessesConfiguration().beersAccesses()))
    );

    @Test
    void shouldNotAuthorizedUnauthorizedAction() {
        assertThat(checker.can(AccessContext.of(admin(), "unauthorized", cloackOfFeathersId()))).isFalse();
    }

    @Test
    void shouldAuthorizedAuthorizedAction() {
        assertThat(checker.can(AccessContext.of(admin(), "create", cloackOfFeathersId()))).isTrue();
    }
}
