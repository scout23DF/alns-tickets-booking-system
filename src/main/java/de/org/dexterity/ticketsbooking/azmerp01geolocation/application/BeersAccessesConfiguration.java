package de.org.dexterity.ticketsbooking.azmerp01geolocation.application;

import de.org.dexterity.ticketsbooking.shared.authentication.domain.Role;
import de.org.dexterity.ticketsbooking.shared.kipe.domain.RolesAccesses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeersAccessesConfiguration {

    @Bean
    RolesAccesses beersAccesses() {
        return RolesAccesses.builder()
            .role(Role.ADMIN)
            .allAuthorized("create", BeerResource.BEERS)
            .allAuthorized("remove", BeerResource.BEERS)
            .and()
            .build();
    }
}
