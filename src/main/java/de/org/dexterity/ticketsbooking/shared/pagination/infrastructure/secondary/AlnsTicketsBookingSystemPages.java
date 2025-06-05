package de.org.dexterity.ticketsbooking.shared.pagination.infrastructure.secondary;

import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;
import de.org.dexterity.ticketsbooking.shared.pagination.domain.AlnsTicketsBookingSystemPage;
import de.org.dexterity.ticketsbooking.shared.pagination.domain.AlnsTicketsBookingSystemPageable;
import java.util.function.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class AlnsTicketsBookingSystemPages {

    private AlnsTicketsBookingSystemPages() {}

    public static Pageable from(AlnsTicketsBookingSystemPageable pagination) {
        return from(pagination, Sort.unsorted());
    }

    public static Pageable from(AlnsTicketsBookingSystemPageable pagination, Sort sort) {
        Assert.notNull("pagination", pagination);
        Assert.notNull("sort", sort);

        return PageRequest.of(pagination.page(), pagination.pageSize(), sort);
    }

    public static <S, T> AlnsTicketsBookingSystemPage<T> from(Page<S> springPage, Function<S, T> mapper) {
        Assert.notNull("springPage", springPage);
        Assert.notNull("mapper", mapper);

        return AlnsTicketsBookingSystemPage.builder(springPage.getContent().stream().map(mapper).toList())
            .currentPage(springPage.getNumber())
            .pageSize(springPage.getSize())
            .totalElementsCount(springPage.getTotalElements())
            .build();
    }
}
