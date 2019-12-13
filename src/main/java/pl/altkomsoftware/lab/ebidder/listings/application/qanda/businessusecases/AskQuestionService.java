package pl.altkomsoftware.lab.ebidder.listings.application.qanda.businessusecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.EventPublisher;
import pl.altkomsoftware.lab.ebidder.listings.domain.listings.ListingRepository;
import pl.altkomsoftware.lab.ebidder.listings.domain.qanda.Question;
import pl.altkomsoftware.lab.ebidder.listings.domain.qanda.QuestionRepository;
import pl.altkomsoftware.lab.ebidder.listings.domain.qanda.QuestionSubmitted;
import pl.altkomsoftware.lab.ebidder.listings.infrastructure.time.SystemClock;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AskQuestionService {

    private final ListingRepository listings;
    private final QuestionRepository questions;
    private final EventPublisher eventPublisher;

    public void ask(UUID listingId, UUID memberId, String question) {
        var listing = listings.findBy(listingId);
        Question askedQuestion = listing.askQuestion(memberId, question, SystemClock.now());
        questions.add(askedQuestion);

        eventPublisher.publish(new QuestionSubmitted(listingId, askedQuestion.getId()));
    }
}
