package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain;

import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;
import java.math.BigDecimal;
import java.math.RoundingMode;

public record Amount(BigDecimal amount) {
    public static final Amount ZERO = new Amount(BigDecimal.ZERO);

    public Amount(BigDecimal amount) {
        Assert.field("amount", amount).notNull().min(BigDecimal.ZERO);

        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal get() {
        return amount();
    }

    public Amount times(int value) {
        return new Amount(amount().multiply(new BigDecimal(value)));
    }

    public Amount add(Amount other) {
        Assert.notNull("other", other);

        return new Amount(amount().add(other.amount()));
    }
}
