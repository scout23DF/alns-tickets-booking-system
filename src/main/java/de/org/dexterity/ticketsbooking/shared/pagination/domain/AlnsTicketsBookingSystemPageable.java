package de.org.dexterity.ticketsbooking.shared.pagination.domain;

import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;
import de.org.dexterity.ticketsbooking.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AlnsTicketsBookingSystemPageable {

    private final int page;
    private final int pageSize;
    private final int offset;

    public AlnsTicketsBookingSystemPageable(int page, int pageSize) {
        Assert.field("page", page).min(0);
        Assert.field("pageSize", pageSize).min(1).max(100);

        this.page = page;
        this.pageSize = pageSize;
        offset = page * pageSize;
    }

    public int page() {
        return page;
    }

    public int pageSize() {
        return pageSize;
    }

    public int offset() {
        return offset;
    }

    @Override
    @ExcludeFromGeneratedCodeCoverage
    public int hashCode() {
        return new HashCodeBuilder().append(page).append(pageSize).build();
    }

    @Override
    @ExcludeFromGeneratedCodeCoverage
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        AlnsTicketsBookingSystemPageable other = (AlnsTicketsBookingSystemPageable) obj;
        return new EqualsBuilder().append(page, other.page).append(pageSize, other.pageSize).build();
    }
}
