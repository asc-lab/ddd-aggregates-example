package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.Identity;

import java.util.UUID;

public class AuctionId extends Identity {

    public AuctionId(UUID id) {
        if(id == null)
            throw new IllegalArgumentException("ID cannot be null");

        this.id = id;
    }
}
