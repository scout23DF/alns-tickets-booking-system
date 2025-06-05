package de.org.dexterity.ticketsbooking.cucumber.rest;

public interface HeaderAsserter<T extends ResponseAsserter> {
    HeaderAsserter<T> containing(String value);

    HeaderAsserter<T> startingWith(String prefix);

    T and();
}
