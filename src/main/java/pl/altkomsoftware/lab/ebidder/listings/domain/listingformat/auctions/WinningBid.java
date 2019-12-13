package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.ValueObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = false)
public class WinningBid extends ValueObject {

    private UUID bidder;
    private Money maximumBid;
    private LocalDateTime timeOfBid;
    private Price currentAuctionPrice;

    public WinningBid(UUID bidder, Money maximumBid, LocalDateTime timeOfBid, Money currentAuctionPrice) {
        if(bidder == null)
            throw new IllegalArgumentException("Bidder cannot be null");
        if(maximumBid == null)
            throw new IllegalArgumentException("MaximumBid cannot be null");
        if(timeOfBid == null)
            throw new IllegalArgumentException("TimeOfBid cannot be null");

        this.bidder = bidder;
        this.maximumBid = maximumBid;
        this.timeOfBid = timeOfBid;
        this.currentAuctionPrice = new Price(currentAuctionPrice);
    }

    public WinningBid raiseMaximumBidTo(Money newAmount) {
        if(newAmount.greaterThan(maximumBid))
            return new WinningBid(bidder, newAmount, LocalDateTime.now(), currentAuctionPrice.getAmount());
        else
            throw new MaximumBidNotExceededException("New Maximum bid  must be greater than current maximum bid.");
    }

    public boolean wasMadeBy(UUID bidder) {
        return this.bidder.equals(bidder);
    }

    public boolean canBeExceededBy(Money offer) {
        return this.currentAuctionPrice.canBeExceededBy(offer);
    }

    public boolean hasNotReachedMaximumBid() {
        return this.maximumBid.greaterThan(currentAuctionPrice.getAmount());
    }

}
