package de.org.dexterity.ticketsbooking.shared.authentication.domain;

import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public record Username(String username) {
    public Username {
        Assert.field("username", username).notBlank().maxLength(100);
    }

    public String get() {
        return username();
    }

    public static Optional<Username> of(String username) {
        return Optional.ofNullable(username).filter(StringUtils::isNotBlank).map(Username::new);
    }
}
