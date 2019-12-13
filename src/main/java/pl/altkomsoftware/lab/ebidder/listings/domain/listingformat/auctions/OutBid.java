package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.DomainEvent;

import java.util.UUID;

@Getter
public class OutBid implements DomainEvent {

    private AuctionId auctionId;
    private UUID bidderId;

    public OutBid(AuctionId auctionId, UUID bidderId) {
        if(auctionId == null)
            throw new IllegalArgumentException("AuctionId cannot be null");
        if(bidderId == null)
            throw  new IllegalArgumentException("BidderId cannot be null");

        this.auctionId = auctionId;
        this.bidderId = bidderId;
    }
}
