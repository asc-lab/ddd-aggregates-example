package pl.altkomsoftware.lab.ebidder.listings.domain.qanda;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Question extends Entity<UUID> {

    private UUID listingId;
    private UUID memberId;

    private boolean publishOnListing;
    private LocalDateTime timeOfQuestion;

    private String desc;
    private Answer answer;

    public Question(UUID id, UUID listingId, UUID memberId, LocalDateTime timeOfQuestion, String desc) {
        this.id = id;
        this.listingId = listingId;
        this.memberId = memberId;
        this.timeOfQuestion = timeOfQuestion;
        this.desc = desc;
    }

    public void submitAnAnswer(String answer, boolean publishOnListing, LocalDateTime timeOfAnswer) {
        this.publishOnListing = publishOnListing;
        this.answer = new Answer(timeOfAnswer, answer);
    }
}
