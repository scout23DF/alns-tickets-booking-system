package de.org.dexterity.ticketsbooking.shared.pagination.domain;

import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import de.org.dexterity.ticketsbooking.shared.error.domain.NumberValueTooHighException;
import de.org.dexterity.ticketsbooking.shared.error.domain.NumberValueTooLowException;
import org.junit.jupiter.api.Test;

@UnitTest
class AlnsTicketsBookingSystemPageableTest {

    @Test
    void shouldNotBuildWithNegativePage() {
        assertThatThrownBy(() -> new AlnsTicketsBookingSystemPageable(-1, 10))
            .isExactlyInstanceOf(NumberValueTooLowException.class)
            .hasMessageContaining("page");
    }

    @Test
    void shouldNotBuildWithPageSizeAtZero() {
        assertThatThrownBy(() -> new AlnsTicketsBookingSystemPageable(0, 0))
            .isExactlyInstanceOf(NumberValueTooLowException.class)
            .hasMessageContaining("pageSize");
    }

    @Test
    void shouldNotBuildWithPageSizeOverHundred() {
        assertThatThrownBy(() -> new AlnsTicketsBookingSystemPageable(0, 101))
            .isExactlyInstanceOf(NumberValueTooHighException.class)
            .hasMessageContaining("pageSize");
    }

    @Test
    void shouldGetFirstPageInformation() {
        var pageable = new AlnsTicketsBookingSystemPageable(0, 15);

        assertThat(pageable.page()).isZero();
        assertThat(pageable.pageSize()).isEqualTo(15);
        assertThat(pageable.offset()).isZero();
    }

    @Test
    void shouldGetPageableInformation() {
        var pageable = new AlnsTicketsBookingSystemPageable(2, 15);

        assertThat(pageable.page()).isEqualTo(2);
        assertThat(pageable.pageSize()).isEqualTo(15);
        assertThat(pageable.offset()).isEqualTo(30);
    }
}
