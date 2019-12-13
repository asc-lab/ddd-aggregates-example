package pl.altkomsoftware.lab.ebidder.listings.application.auctions.businessusecases;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class AuctionCreation {
    private BigDecimal startingPrice;
    private UUID sellerId;
    private LocalDateTime endsAt;
}
