package pl.altkomsoftware.lab.ebidder.listings.application.auctions.businessusecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.Identity;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.Auction;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.AuctionRepository;
import pl.altkomsoftware.lab.ebidder.listings.domain.listings.FormatType;
import pl.altkomsoftware.lab.ebidder.listings.domain.listings.Listing;
import pl.altkomsoftware.lab.ebidder.listings.domain.listings.ListingFormat;
import pl.altkomsoftware.lab.ebidder.listings.domain.listings.ListingRepository;
import pl.altkomsoftware.lab.ebidder.listings.domain.sellers.SellerRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateAuctionService {

    private final AuctionRepository auctions;
    private final SellerRepository sellerRepository;
    private final ListingRepository listings;

    public UUID create(AuctionCreation command) {
        var auctionId = Identity.newId();
        var listingId = Identity.newId();
        var startingPrice = new Money(command.getStartingPrice());

        var listing = new Listing(listingId, command.getSellerId(), new ListingFormat(auctionId, FormatType.AUCTION));
        var auction = new Auction(auctionId, listingId, startingPrice, command.getEndsAt());

        var seller = sellerRepository.getSeller(command.getSellerId());
        if(seller != null && seller.isCanList()) {
            listings.add(listing);
            auctions.add(auction);
        }

        return auctionId;
    }
}
