package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.ValueObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = false)
public class Offer extends ValueObject {

    private UUID bidder;
    private Money maximumBid;
    private LocalDateTime timeOfOffer;

    public Offer(UUID bidderId, Money maximumBid, LocalDateTime timeOfOffer) {
        if(bidderId == null)
            throw new IllegalArgumentException("BidderId cannot be null");
        if(maximumBid == null)
            throw new IllegalArgumentException("MaximumBid cannot be null");
        if(timeOfOffer == null)
            throw new IllegalArgumentException("TimeOfOffer cannot be null");

        this.bidder = bidderId;
        this.maximumBid = maximumBid;
        this.timeOfOffer = timeOfOffer;
    }
}
