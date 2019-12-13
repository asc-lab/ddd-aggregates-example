package pl.altkomsoftware.lab.ebidder.listings.infrastructure.db;

import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.listings.Listing;
import pl.altkomsoftware.lab.ebidder.listings.domain.listings.ListingRepository;

import java.util.UUID;

@Component
public class InMemoryListingRepository implements ListingRepository {
    @Override
    public void add(Listing listing) {

    }

    @Override
    public Listing findBy(UUID id) {
        return null;
    }
}
