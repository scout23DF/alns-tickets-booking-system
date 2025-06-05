package de.org.dexterity.ticketsbooking.azmerp01geolocation.application;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeerToCreate;
import de.org.dexterity.ticketsbooking.shared.kipe.application.AccessChecker;
import de.org.dexterity.ticketsbooking.shared.kipe.application.AccessContext;
import de.org.dexterity.ticketsbooking.shared.kipe.application.AlnsTicketsBookingSystemAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerToCreateAccessChecker implements AccessChecker<BeerToCreate> {

    private final AlnsTicketsBookingSystemAuthorizations authorizations;

    public BeerToCreateAccessChecker(AlnsTicketsBookingSystemAuthorizations authorizations) {
        this.authorizations = authorizations;
    }

    @Override
    public boolean can(AccessContext<BeerToCreate> access) {
        return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
    }
}
