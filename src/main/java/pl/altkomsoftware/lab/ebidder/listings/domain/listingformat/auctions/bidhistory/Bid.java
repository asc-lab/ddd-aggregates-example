package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.bidhistory;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.ValueObject;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.AuctionId;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = false)
public class Bid extends ValueObject<Bid> {

    private AuctionId auctionId;
    private UUID bidderId;
    private Money amountBid;
    private LocalDateTime timeOfBid;

    public Bid(AuctionId auctionId, UUID bidderId, Money amountBid, LocalDateTime timeOfBid) {
        if(auctionId == null)
            throw new IllegalArgumentException("AuctionId cannot be null");
        if(bidderId == null)
            throw new IllegalArgumentException("BidderId cannot be null");
        if(amountBid == null)
            throw new IllegalArgumentException("AmountBid cannot be null");
        if(timeOfBid == null)
            throw new IllegalArgumentException("TimeOfBid cannot be null");

        this.auctionId = auctionId;
        this.bidderId = bidderId;
        this.amountBid = amountBid;
        this.timeOfBid = timeOfBid;
    }
}
