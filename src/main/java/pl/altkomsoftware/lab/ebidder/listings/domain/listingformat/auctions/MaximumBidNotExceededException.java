package pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions;

import pl.altkomsoftware.lab.ebidder.listings.domain.BusinessException;

public class MaximumBidNotExceededException extends BusinessException {
    public MaximumBidNotExceededException(String message) {
        super(message);
    }
}
