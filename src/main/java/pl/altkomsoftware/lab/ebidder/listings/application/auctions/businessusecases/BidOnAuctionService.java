package pl.altkomsoftware.lab.ebidder.listings.application.auctions.businessusecases;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.EventPublisher;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.AuctionId;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.AuctionRepository;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.BidPlaced;
import pl.altkomsoftware.lab.ebidder.listings.domain.listingformat.auctions.Offer;
import pl.altkomsoftware.lab.ebidder.listings.domain.members.MemberRepository;
import pl.altkomsoftware.lab.ebidder.listings.infrastructure.time.SystemClock;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BidOnAuctionService {

    private final AuctionRepository auctions;
    private final MemberRepository memberRepository;
    private final EventPublisher eventPublisher;

    public void bid(UUID auctionId, UUID memberId, BigDecimal amount) {
        var member = memberRepository.getMember(memberId);

        if(member.isCanBid()) {
            var auction = auctions.findBy(auctionId);
            var bidAmount = new Money(amount);
            var offer = new Offer(memberId, bidAmount, SystemClock.now());
            auction.placeBidFor(offer, SystemClock.now());

            eventPublisher.publish(new BidPlaced(new AuctionId(auctionId), memberId, bidAmount, SystemClock.now()));
        }
    }
}
