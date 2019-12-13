package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.ValueObject;

@EqualsAndHashCode(callSuper = false)
public class Price extends ValueObject<Price> {
    @Getter
    private Money amount;

    public Price(Money amount) {
        if (amount == null)
            throw new IllegalArgumentException("Ammount cannot be null!");

        this.amount = amount;
    }

    public Money bidIncrement() {
        if (amount.greaterOrEqual(Money.from("0.01")) && amount.lowerOrEqual(Money.from("0.99")))
            return amount.add(Money.from("0.05"));

        if (amount.greaterOrEqual(Money.from("1.00")) && amount.lowerOrEqual(Money.from("4.99")))
            return amount.add(Money.from("0.20"));

        if (amount.greaterOrEqual(Money.from("5.00")) && amount.lowerOrEqual(Money.from("14.99")))
            return amount.add(Money.from("0.50"));

        return amount.add(Money.from("1.00"));
    }

    public boolean canBeExceededBy(Money offer) {
        return offer.greaterOrEqual(bidIncrement());
    }
}
