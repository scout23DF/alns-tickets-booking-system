package de.org.dexterity.ticketsbooking.azmerp01geolocation.application;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeerId;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.Beer;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeerToCreate;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.Beers;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeersCreator;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeersRemover;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeersRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BeersApplicationService {

    private final BeersRepository beers;
    private final BeersCreator creator;
    private final BeersRemover remover;

    public BeersApplicationService(BeersRepository beers) {
        this.beers = beers;

        creator = new BeersCreator(beers);
        remover = new BeersRemover(beers);
    }

    @Transactional
    @PreAuthorize("can('create', #beerToCreate)")
    public Beer create(BeerToCreate beerToCreate) {
        return creator.create(beerToCreate);
    }

    @Transactional
    @PreAuthorize("can('remove', #beer)")
    public void remove(BeerId beer) {
        remover.remove(beer);
    }

    @Transactional(readOnly = true)
    public Beers catalog() {
        return beers.catalog();
    }
}
