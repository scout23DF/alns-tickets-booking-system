package de.org.dexterity.ticketsbooking.shared.pagination.domain;

import de.org.dexterity.ticketsbooking.shared.pagination.domain.AlnsTicketsBookingSystemPage.AlnsTicketsBookingSystemPageBuilder;
import java.util.List;

public final class AlnsTicketsBookingSystemPagesFixture {

    private AlnsTicketsBookingSystemPagesFixture() {}

    public static AlnsTicketsBookingSystemPage<String> page() {
        return pageBuilder().build();
    }

    public static AlnsTicketsBookingSystemPageBuilder<String> pageBuilder() {
        return AlnsTicketsBookingSystemPage.builder(List.of("test")).currentPage(2).pageSize(10).totalElementsCount(21);
    }
}
