package de.org.dexterity.ticketsbooking.wire.database.infrastructure.secondary;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "de.org.dexterity.ticketsbooking" }, enableDefaultTransactions = false)
class DatabaseConfiguration {}
