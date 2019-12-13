package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Auction extends Entity<AuctionId> {

    private UUID listingId;
    private LocalDateTime endsAt;
    private Money startingPrice;
    private WinningBid winningBid;
    private boolean hasEnded;

    public Auction(UUID id, UUID listingId, Money startingPrice, LocalDateTime endsAt) {
        if (id == null)
            throw new IllegalArgumentException("AuctionId cannot be null");
        if (listingId == null)
            throw new IllegalArgumentException("ListingId cannot be null");
        if (startingPrice == null)
            throw new IllegalArgumentException("StartingPrice cannot be null");
        if (endsAt == null)
            throw new IllegalArgumentException("EndsAt cannot be null");

        this.id = new AuctionId(id);
        this.listingId = listingId;
        this.endsAt = endsAt;
        this.startingPrice = startingPrice;
    }

    public void reduceTheStartingPrice() {
        //Only if no bids and more than 12 hours left
    }

    private boolean isEnded(LocalDateTime currentTime) {
        return endsAt.isBefore(currentTime);
    }

    public boolean canPlaceBid() {
        return !hasEnded;
    }

    public void placeBidFor(Offer offer, LocalDateTime currentTime) {
        if (isEnded(currentTime)) {
            return;
        }

        if (firstOrder()) {
            placeABidForTheFirst(offer);
        } else if (bidderIsIncreasingOwnMaximumBid(offer)) {
            this.winningBid = this.winningBid.raiseMaximumBidTo(offer.getMaximumBid());
        } else if (this.winningBid.canBeExceededBy(offer.getMaximumBid())) {
            var newBids = new AutomaticBidder().generateNextSequenceOfBidsAfter(offer, this.winningBid);

            for (var bid : newBids) {
                place(bid);
            }
        }
    }

    private boolean bidderIsIncreasingOwnMaximumBid(Offer offer) {
        return this.winningBid.wasMadeBy(offer.getBidder())
                && offer.getMaximumBid().greaterThan(this.winningBid.getMaximumBid());
    }

    private boolean firstOrder() {
        return this.winningBid == null;
    }

    private void placeABidForTheFirst(Offer offer) {
        if (offer.getMaximumBid().greaterOrEqual(this.startingPrice))
            place(new WinningBid(
                    offer.getBidder(),
                    offer.getMaximumBid(),
                    offer.getTimeOfOffer(),
                    startingPrice)
            );
    }

    private void place(WinningBid newBid) {
        if (!firstOrder() && this.winningBid.wasMadeBy(newBid.getBidder())) {
            //DomainEvents.Raise(new OutBid(Id, WinningBid.Bidder));
        }

        this.winningBid = newBid;
        //DomainEvents.Raise(new BidPlaced(Id, newBid.Bidder, newBid.CurrentAuctionPrice.Amount, newBid.TimeOfBid));

        //instead raise events using DomainEvents class you can  return list of events and publish it in application service
    }

}
