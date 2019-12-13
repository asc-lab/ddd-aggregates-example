package pl.altkomsoftware.lab.ebidder.listings.infrastructure.db;

import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.Auction;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.AuctionRepository;

import java.util.UUID;

@Component
public class InMemoryAuctionRepository implements AuctionRepository {
    @Override
    public void add(Auction auction) {

    }

    @Override
    public Auction findBy(UUID id) {
        return null;
    }
}
