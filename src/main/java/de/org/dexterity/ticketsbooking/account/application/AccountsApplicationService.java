package de.org.dexterity.ticketsbooking.account.application;

import de.org.dexterity.ticketsbooking.account.domain.Account;
import de.org.dexterity.ticketsbooking.account.domain.AccountsRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AccountsApplicationService {

    private final AccountsRepository accounts;

    public AccountsApplicationService(AccountsRepository accounts) {
        this.accounts = accounts;
    }

    public Optional<Account> authenticatedUserAccount() {
        return accounts.authenticatedUserAccount();
    }
}
