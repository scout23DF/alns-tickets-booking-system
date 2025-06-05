package de.org.dexterity.ticketsbooking.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CucumberJpaReset {

    private final Collection<JpaRepository<?, ?>> repositories;

    CucumberJpaReset(@Autowired(required = false) Collection<JpaRepository<?, ?>> repositories) {
        this.repositories = repositories;
    }

    @After
    @Before
    @Transactional
    public void wipeData() {
        if (repositories == null) {
            return;
        }

        repositories.forEach(JpaRepository::deleteAllInBatch);
    }
}
