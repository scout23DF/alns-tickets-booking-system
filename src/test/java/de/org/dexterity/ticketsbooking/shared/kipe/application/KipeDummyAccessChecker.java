package de.org.dexterity.ticketsbooking.shared.kipe.application;

import de.org.dexterity.ticketsbooking.shared.kipe.domain.KipeDummy;
import org.springframework.stereotype.Component;

@Component
class KipeDummyAccessChecker implements AccessChecker<KipeDummy> {

    @Override
    public boolean can(AccessContext<KipeDummy> access) {
        return access.authentication() != null && access.element().value().equals("authorized");
    }
}
