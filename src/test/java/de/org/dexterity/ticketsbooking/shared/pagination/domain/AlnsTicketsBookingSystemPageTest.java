package de.org.dexterity.ticketsbooking.shared.pagination.domain;

import static de.org.dexterity.ticketsbooking.shared.pagination.domain.AlnsTicketsBookingSystemPagesFixture.*;
import static org.assertj.core.api.Assertions.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import de.org.dexterity.ticketsbooking.shared.error.domain.MissingMandatoryValueException;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class AlnsTicketsBookingSystemPageTest {

    @Test
    void shouldGetEmptySinglePageWithoutContent() {
        AlnsTicketsBookingSystemPage<String> page = AlnsTicketsBookingSystemPage.singlePage(null);

        assertEmptyPage(page);
    }

    @Test
    void shouldGetEmptySinglePageFromBuilderWithoutContent() {
        AlnsTicketsBookingSystemPage<?> page = AlnsTicketsBookingSystemPage.builder(null).build();

        assertEmptyPage(page);
    }

    private void assertEmptyPage(AlnsTicketsBookingSystemPage<?> page) {
        assertThat(page.content()).isEmpty();
        assertThat(page.currentPage()).isZero();
        assertThat(page.pageSize()).isZero();
        assertThat(page.totalElementsCount()).isZero();
    }

    @Test
    void shouldGetSinglePage() {
        AlnsTicketsBookingSystemPage<String> page = AlnsTicketsBookingSystemPage.singlePage(List.of("test", "dummy"));

        assertSinglePage(page);
    }

    @Test
    void shouldGetSinglePageFromBuilderWithContentOnly() {
        AlnsTicketsBookingSystemPage<String> page = AlnsTicketsBookingSystemPage.builder(List.of("test", "dummy")).build();

        assertSinglePage(page);
    }

    private void assertSinglePage(AlnsTicketsBookingSystemPage<String> page) {
        assertThat(page.content()).containsExactly("test", "dummy");
        assertThat(page.currentPage()).isZero();
        assertThat(page.pageSize()).isEqualTo(2);
        assertThat(page.totalElementsCount()).isEqualTo(2);
        assertThat(page.pageCount()).isEqualTo(1);
    }

    @Test
    void shouldGetFullPage() {
        AlnsTicketsBookingSystemPage<String> page = pageBuilder().build();

        assertThat(page.content()).containsExactly("test");
        assertThat(page.currentPage()).isEqualTo(2);
        assertThat(page.pageSize()).isEqualTo(10);
        assertThat(page.totalElementsCount()).isEqualTo(21);
        assertThat(page.pageCount()).isEqualTo(3);
    }

    @Test
    void shouldNotMapWithoutMapper() {
        assertThatThrownBy(() -> pageBuilder().build().map(null))
            .isExactlyInstanceOf(MissingMandatoryValueException.class)
            .hasMessageContaining("mapper");
    }

    @Test
    void shouldMapPage() {
        AlnsTicketsBookingSystemPage<String> page = pageBuilder().build().map(entry -> "hey");

        assertThat(page.content()).containsExactly("hey");
        assertThat(page.currentPage()).isEqualTo(2);
        assertThat(page.pageSize()).isEqualTo(10);
        assertThat(page.totalElementsCount()).isEqualTo(21);
        assertThat(page.pageCount()).isEqualTo(3);
    }

    @Test
    void shouldNotBeLastForFirstPage() {
        assertThat(pageBuilder().currentPage(0).build().isNotLast()).isTrue();
    }

    @Test
    void shouldBeLastWithOnePage() {
        assertThat(AlnsTicketsBookingSystemPage.singlePage(List.of("d")).isNotLast()).isFalse();
    }

    @Test
    void shouldBeLastPageWithoutContent() {
        AlnsTicketsBookingSystemPage<Object> page = AlnsTicketsBookingSystemPage.builder(List.of())
            .currentPage(0)
            .pageSize(1)
            .totalElementsCount(0)
            .build();
        assertThat(page.isNotLast()).isFalse();
    }

    @Test
    void shouldBeLastForLastPage() {
        assertThat(pageBuilder().currentPage(2).build().isNotLast()).isFalse();
    }

    @Test
    void shouldGetPageFromElements() {
        AlnsTicketsBookingSystemPage<String> page = AlnsTicketsBookingSystemPage.of(
            List.of("hello", "java", "world"),
            new AlnsTicketsBookingSystemPageable(1, 1)
        );

        assertThat(page.currentPage()).isEqualTo(1);
        assertThat(page.hasNext()).isTrue();
        assertThat(page.hasPrevious()).isTrue();
        assertThat(page.pageCount()).isEqualTo(3);
        assertThat(page.pageSize()).isEqualTo(1);
        assertThat(page.content()).containsExactly("java");
    }

    @Test
    void shouldGetEmptyPageFromOutOfBoundElements() {
        AlnsTicketsBookingSystemPage<String> page = AlnsTicketsBookingSystemPage.of(
            List.of("hello", "java", "world"),
            new AlnsTicketsBookingSystemPageable(4, 1)
        );

        assertThat(page.currentPage()).isEqualTo(4);
        assertThat(page.hasNext()).isFalse();
        assertThat(page.hasPrevious()).isTrue();
        assertThat(page.pageCount()).isEqualTo(3);
        assertThat(page.pageSize()).isEqualTo(1);
        assertThat(page.content()).isEmpty();
    }

    @Test
    void shouldGetPageWithLessThanExpectedElements() {
        AlnsTicketsBookingSystemPage<String> page = AlnsTicketsBookingSystemPage.of(
            List.of("hello", "java", "world"),
            new AlnsTicketsBookingSystemPageable(0, 4)
        );

        assertThat(page.currentPage()).isZero();
        assertThat(page.hasNext()).isFalse();
        assertThat(page.hasPrevious()).isFalse();
        assertThat(page.pageCount()).isEqualTo(1);
        assertThat(page.pageSize()).isEqualTo(4);
        assertThat(page.content()).hasSize(3);
    }
}
