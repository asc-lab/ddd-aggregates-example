package pl.altkomsoftware.lab.ebidder.listings.domain.listings;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.Money;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.Entity;
import pl.altkomsoftware.lab.ebidder.listings.domain.qanda.Question;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Listing extends Entity<UUID> {

    private ListingFormat format;
    private String title;
    private String description;
    private String condition;
    private UUID sellerId;

    private Money postageCosts;

    private String paymentMethodsAccepted;
    private String dispatchTime;

    public Listing(UUID id, UUID sellerId, ListingFormat format) {
        this.id = id;
        this.sellerId = sellerId;
        this.format = format;
    }

    public Question askQuestion(UUID memberId, String question, LocalDateTime timeOfQuestion) {
        return new Question(UUID.randomUUID(), this.id, memberId, timeOfQuestion, question);
    }
}
