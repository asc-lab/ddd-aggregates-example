package pl.altkomsoftware.lab.ebidder.listings.domain.qanda;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.DomainEvent;

import java.util.UUID;

@Getter
public class QuestionAnswered implements DomainEvent {
    private UUID listingId;
    private UUID questionId;

    public QuestionAnswered(UUID listingId, UUID questionId) {
        if(listingId == null)
            throw new IllegalArgumentException("Listing cannot be null");
        if(questionId == null)
            throw new IllegalArgumentException("QuestionId cannot be null");

        this.listingId = listingId;
        this.questionId = questionId;
    }
}
