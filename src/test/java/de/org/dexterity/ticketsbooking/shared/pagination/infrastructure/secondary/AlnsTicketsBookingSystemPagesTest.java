package de.org.dexterity.ticketsbooking.shared.pagination.infrastructure.secondary;

import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import de.org.dexterity.ticketsbooking.shared.error.domain.MissingMandatoryValueException;
import de.org.dexterity.ticketsbooking.shared.pagination.domain.AlnsTicketsBookingSystemPage;
import de.org.dexterity.ticketsbooking.shared.pagination.domain.AlnsTicketsBookingSystemPageable;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@UnitTest
class AlnsTicketsBookingSystemPagesTest {

    @Test
    void shouldNotBuildPageableFromNullAlnsTicketsBookingSystemPageable() {
        assertThatThrownBy(() -> AlnsTicketsBookingSystemPages.from(null))
            .isExactlyInstanceOf(MissingMandatoryValueException.class)
            .hasMessageContaining("pagination");
    }

    @Test
    void shouldBuildPageableFromAlnsTicketsBookingSystemPageable() {
        Pageable pagination = AlnsTicketsBookingSystemPages.from(pagination());

        assertThat(pagination.getPageNumber()).isEqualTo(2);
        assertThat(pagination.getPageSize()).isEqualTo(15);
        assertThat(pagination.getSort()).isEqualTo(Sort.unsorted());
    }

    @Test
    void shouldNotBuildWithoutSort() {
        assertThatThrownBy(() -> AlnsTicketsBookingSystemPages.from(pagination(), null))
            .isExactlyInstanceOf(MissingMandatoryValueException.class)
            .hasMessageContaining("sort");
    }

    @Test
    void shouldBuildPageableFromAlnsTicketsBookingSystemPageableAndSort() {
        Pageable pagination = AlnsTicketsBookingSystemPages.from(pagination(), Sort.by("dummy"));

        assertThat(pagination.getPageNumber()).isEqualTo(2);
        assertThat(pagination.getPageSize()).isEqualTo(15);
        assertThat(pagination.getSort()).isEqualTo(Sort.by("dummy"));
    }

    private AlnsTicketsBookingSystemPageable pagination() {
        return new AlnsTicketsBookingSystemPageable(2, 15);
    }

    @Test
    void shouldNotConvertFromSpringPageWithoutSpringPage() {
        assertThatThrownBy(() -> AlnsTicketsBookingSystemPages.from(null, source -> source))
            .isExactlyInstanceOf(MissingMandatoryValueException.class)
            .hasMessageContaining("springPage");
    }

    @Test
    void shouldNotConvertFromSpringPageWithoutMapper() {
        assertThatThrownBy(() -> AlnsTicketsBookingSystemPages.from(springPage(), null))
            .isExactlyInstanceOf(MissingMandatoryValueException.class)
            .hasMessageContaining("mapper");
    }

    @Test
    void shouldConvertFromSpringPage() {
        AlnsTicketsBookingSystemPage<String> page = AlnsTicketsBookingSystemPages.from(springPage(), Function.identity());

        assertThat(page.content()).containsExactly("test");
        assertThat(page.currentPage()).isEqualTo(2);
        assertThat(page.pageSize()).isEqualTo(10);
        assertThat(page.totalElementsCount()).isEqualTo(30);
    }

    private PageImpl<String> springPage() {
        return new PageImpl<>(List.of("test"), PageRequest.of(2, 10), 30);
    }
}
