package de.org.dexterity.ticketsbooking.azmerp01geolocation.infrastructure.secondary;

import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.BeerId;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.Beer;
import de.org.dexterity.ticketsbooking.azmerp01geolocation.domain.beer.BeerSellingState;
import de.org.dexterity.ticketsbooking.shared.error.domain.Assert;
import de.org.dexterity.ticketsbooking.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "beers")
class BeerEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "selling_state")
    private BeerSellingState sellingState;

    public static BeerEntity from(Beer beer) {
        Assert.notNull("beer", beer);

        return new BeerEntity()
            .id(beer.id().get())
            .name(beer.name().get())
            .unitPrice(beer.unitPrice().get())
            .sellingState(beer.sellingState());
    }

    private BeerEntity id(UUID id) {
        this.id = id;

        return this;
    }

    private BeerEntity name(String name) {
        this.name = name;

        return this;
    }

    private BeerEntity unitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;

        return this;
    }

    private BeerEntity sellingState(BeerSellingState sellingState) {
        this.sellingState = sellingState;

        return this;
    }

    public Beer toDomain() {
        return Beer.builder().id(new BeerId(id)).name(name).unitPrice(unitPrice).sellingState(sellingState).build();
    }

    @Override
    @ExcludeFromGeneratedCodeCoverage
    public int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    @Override
    @ExcludeFromGeneratedCodeCoverage
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BeerEntity other = (BeerEntity) obj;

        return new EqualsBuilder().append(id, other.id).isEquals();
    }
}
