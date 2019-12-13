package pl.altkomsoftware.lab.ebidder.listings.domain.qanda;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.ValueObject;

import java.time.LocalDateTime;

@Getter
public class Answer extends ValueObject<Answer> {
    private LocalDateTime dateAnswered;
    private String text;

    public Answer(LocalDateTime dateAnswered, String text) {
        this.dateAnswered = dateAnswered;
        this.text = text;
    }
}
