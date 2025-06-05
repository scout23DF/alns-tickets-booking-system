package de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeerId;

class UnknownBeerException extends RuntimeException {

    public UnknownBeerException(BeerId id) {
        super("Beer " + id.get() + " is unknown");
    }
}
