package de.org.dexterity.ticketsbooking.account.infrastructure.secondary;

import de.org.dexterity.ticketsbooking.account.domain.Account;
import de.org.dexterity.ticketsbooking.account.domain.AccountsRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
class OAuth2AccountsRepository implements AccountsRepository {

    private final OAuth2AuthenticationReader oAuth2Reader;

    public OAuth2AccountsRepository(OAuth2AuthenticationReader oAuth2Reader) {
        this.oAuth2Reader = oAuth2Reader;
    }

    @Override
    public Optional<Account> authenticatedUserAccount() {
        return oAuth2Reader.authenticatedUserAccount();
    }
}
