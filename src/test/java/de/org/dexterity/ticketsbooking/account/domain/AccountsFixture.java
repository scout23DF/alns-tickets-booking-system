package de.org.dexterity.ticketsbooking.account.domain;

import static de.org.dexterity.ticketsbooking.shared.useridentity.domain.UsersIdentitiesFixture.*;

import de.org.dexterity.ticketsbooking.shared.authentication.domain.Role;
import java.util.List;

public final class AccountsFixture {

    private AccountsFixture() {}

    public static Account account() {
        return Account.builder()
            .username(username())
            .firstname(firstname())
            .lastname(lastname())
            .email(email())
            .roles(List.of(Role.ADMIN.key()))
            .build();
    }
}
