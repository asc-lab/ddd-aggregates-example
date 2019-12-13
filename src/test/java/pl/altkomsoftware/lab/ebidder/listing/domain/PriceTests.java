package pl.altkomsoftware.lab.ebidder.listing.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.Price;

public class PriceTests {

    @Test
    public void cannotCreatePriceForNullAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Price(null);
        });
    }

    @Test
    public void whenAmountIsLowerThan0_99_bidIncrementAdd0_05() {
        //given
        Price startedPrice = new Price(Money.from("0.88"));
        //when
        Money afterBidIncrement = startedPrice.bidIncrement();
        //then
        Assertions.assertEquals(Money.from("0.93"), afterBidIncrement);
    }

    @Test
    public void whenAmountGreaterThan0_99_AndIsLowerThan4_99_bidIncrementAdd0_20() {
        //given
        Price startedPrice = new Price(Money.from("2.00"));
        //when
        Money afterBidIncrement = startedPrice.bidIncrement();
        //then
        Assertions.assertEquals(Money.from("2.20"), afterBidIncrement);
    }

    @Test
    public void whenAmountGreaterThan4_99_AndIsLowerThan14_99_bidIncrementAdd0_50() {
        //given
        Price startedPrice = new Price(Money.from("13.00"));
        //when
        Money afterBidIncrement = startedPrice.bidIncrement();
        //then
        Assertions.assertEquals(Money.from("13.50"), afterBidIncrement);
    }

    @Test
    public void whenAmountGreaterThan14_99_bidIncrementAdd1_00() {
        //given
        Price startedPrice = new Price(Money.from("20.00"));
        //when
        Money afterBidIncrement = startedPrice.bidIncrement();
        //then
        Assertions.assertEquals(Money.from("21.00"), afterBidIncrement);
    }

    @Test
    public void priceCanBeExceededWhenProvidedOfferIsGreaterThanBidIncrement() {
        //given
        Price startedPrice = new Price(Money.from("20.00"));
        Money greaterOfferAfterBid = Money.from("21.01");
        //then
        Assertions.assertTrue(startedPrice.canBeExceededBy(greaterOfferAfterBid));
    }

    @Test
    public void priceCannotBeExceededWhenProvidedOfferIsLowerThanBidIncrement() {
        //given
        Price startedPrice = new Price(Money.from("20.00"));
        Money tooLowOfferAfterBid = Money.from("20.99");
        //then
        Assertions.assertFalse(startedPrice.canBeExceededBy(tooLowOfferAfterBid));
    }
}
