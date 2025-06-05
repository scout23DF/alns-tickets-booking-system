package de.org.dexterity.ticketsbooking.account.domain;

import java.util.Optional;

public interface AccountsRepository {
    Optional<Account> authenticatedUserAccount();
}
