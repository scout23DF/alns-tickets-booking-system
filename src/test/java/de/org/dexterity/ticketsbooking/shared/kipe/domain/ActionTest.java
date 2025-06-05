package de.org.dexterity.ticketsbooking.shared.kipe.domain;

import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ActionTest {

    @Test
    void shouldGetActionAsToString() {
        assertThat(new Action("act")).hasToString("act");
    }
}
