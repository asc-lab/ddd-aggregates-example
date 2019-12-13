package pl.altkomsoftware.lab.ebidder.listings.infrastructure.db;

import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.sellers.Seller;
import pl.altkomsoftware.lab.ebidder.listings.domain.sellers.SellerRepository;

import java.util.UUID;

@Component
public class InMemorySellerRepository implements SellerRepository {
    @Override
    public Seller getSeller(UUID sellerId) {
        return null;
    }
}
