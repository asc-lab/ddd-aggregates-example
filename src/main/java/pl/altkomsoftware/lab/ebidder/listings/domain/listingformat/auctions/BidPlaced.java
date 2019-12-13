package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.DomainEvent;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class BidPlaced implements DomainEvent {

    private AuctionId auctionId;
    private UUID bidderId;
    private Money amountBid;
    private LocalDateTime timeOfBid;

    public BidPlaced(AuctionId auctionId, UUID bidderId, Money amountBid, LocalDateTime timeOfBid) {
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
