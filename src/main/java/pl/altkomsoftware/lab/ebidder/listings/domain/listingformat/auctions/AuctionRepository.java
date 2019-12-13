package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import java.util.UUID;

public interface AuctionRepository {
    void add(Auction auction);
    Auction findBy(UUID id);
}
