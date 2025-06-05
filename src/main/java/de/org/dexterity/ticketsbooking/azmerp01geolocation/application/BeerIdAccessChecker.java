package de.org.dexterity.ticketsbooking.azmerp01geolocation.application;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeerId;
import de.org.dexterity.ticketsbooking.shared.kipe.application.AccessChecker;
import de.org.dexterity.ticketsbooking.shared.kipe.application.AccessContext;
import de.org.dexterity.ticketsbooking.shared.kipe.application.AlnsTicketsBookingSystemAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerIdAccessChecker implements AccessChecker<BeerId> {

    private final AlnsTicketsBookingSystemAuthorizations authorizations;

    public BeerIdAccessChecker(AlnsTicketsBookingSystemAuthorizations authorizations) {
        this.authorizations = authorizations;
    }

    @Override
    public boolean can(AccessContext<BeerId> access) {
        return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
    }
}
