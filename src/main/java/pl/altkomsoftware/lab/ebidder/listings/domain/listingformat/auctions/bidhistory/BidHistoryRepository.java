package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.bidhistory;

import java.util.UUID;

public interface BidHistoryRepository {
    int numberOfBidsFor(UUID auctionId);
    void add(Bid bid);
}
