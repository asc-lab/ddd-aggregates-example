package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import java.util.ArrayList;
import java.util.Collection;

class AutomaticBidder {

    Collection<WinningBid> generateNextSequenceOfBidsAfter(Offer offer, WinningBid currentWinningBid) {
        var bids = new ArrayList<WinningBid>();

        if (currentWinningBid.getMaximumBid().greaterOrEqual(offer.getMaximumBid())) {
            var bidFromOffer = new WinningBid(
                    offer.getBidder(),
                    offer.getMaximumBid(),
                    offer.getTimeOfOffer(),
                    offer.getMaximumBid()
            );
            bids.add(bidFromOffer);

            bids.add(
                    calculateNextBid(bidFromOffer, new Offer(
                            currentWinningBid.getBidder(),
                            currentWinningBid.getMaximumBid(),
                            currentWinningBid.getTimeOfBid()))
            );
        } else {
            if (currentWinningBid.hasNotReachedMaximumBid()) {
                var currentBiddersLastBid = new WinningBid(
                        currentWinningBid.getBidder(),
                        currentWinningBid.getMaximumBid(),
                        currentWinningBid.getTimeOfBid(),
                        currentWinningBid.getMaximumBid()
                );
                bids.add(currentBiddersLastBid);
                bids.add(calculateNextBid(currentWinningBid, offer));
            } else {
                bids.add(
                        new WinningBid(
                                offer.getBidder(),
                                currentWinningBid.getCurrentAuctionPrice().bidIncrement(),
                                offer.getTimeOfOffer(),
                                offer.getMaximumBid()
                        ));
            }
        }
        return bids;
    }

    private WinningBid calculateNextBid(WinningBid winningBid, Offer offer) {
        return new WinningBid(
                offer.getBidder(),
                offer.getMaximumBid(),
                offer.getTimeOfOffer(),
                winningBid.canBeExceededBy(offer.getMaximumBid())
                        ? winningBid.getCurrentAuctionPrice().bidIncrement()
                        : offer.getMaximumBid()
        );
    }
}
