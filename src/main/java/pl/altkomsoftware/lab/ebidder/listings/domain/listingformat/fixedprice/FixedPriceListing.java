package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.fixedprice;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.Entity;
import pl.altkomsoftware.lab.ebidder.listings.domain.listings.Listing;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class FixedPriceListing extends Entity<UUID> {
    private UUID sellerId;
    private Listing listing;
    private LocalDateTime endsAt;
    private Money buyNowPrice;

    public FixedPriceListing(UUID id, UUID sellerId, Listing listing, LocalDateTime endsAt, Money buyNowPrice) {
        if (id == null)
            throw new IllegalArgumentException("AuctionId cannot be null");
        if (sellerId == null)
            throw new IllegalArgumentException("SellerId cannot be null");
        if (buyNowPrice == null)
            throw new IllegalArgumentException("BuyNowPrice cannot be null");
        if (endsAt == null)
            throw new IllegalArgumentException("EndsAt cannot be null");
        if (listing == null)
            throw new IllegalArgumentException("Listing cannot be null");

        this.id = id;
        this.sellerId = sellerId;
        this.listing = listing;
        this.endsAt = endsAt;
        this.buyNowPrice = buyNowPrice;
    }
}
