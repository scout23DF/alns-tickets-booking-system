package de.org.dexterity.ticketsbooking.shared.kipe.application;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;

@UnitTest
class AccessContextFactoryTest {

    @Test
    void shouldGetNullElementAccessContextFromNullElement() {
        assertThat(AccessContextFactory.of(mock(Authentication.class), "action", null)).isExactlyInstanceOf(NullElementAccessContext.class);
    }

    @Test
    void shouldGetElementAccessContextFromActualElement() {
        assertThat(AccessContextFactory.of(mock(Authentication.class), "action", "element")).isExactlyInstanceOf(
            ElementAccessContext.class
        );
    }
}
