package pl.altkomsoftware.lab.ebidder.listings.domain.sellers;

import java.util.UUID;

public interface SellerRepository {
    Seller getSeller(UUID sellerId);
}
