package pl.altkomsoftware.lab.ebidder.listings.domain.listings;

import java.util.UUID;

public interface ListingRepository {
    void add(Listing listing);
    Listing findBy(UUID id);
}
