package pl.altkomsoftware.lab.ebidder.listings.application.qanda.businessusecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.EventPublisher;
import pl.altkomsoftware.lab.ebidder.listings.domain.qanda.QuestionAnswered;
import pl.altkomsoftware.lab.ebidder.listings.domain.qanda.QuestionRepository;
import pl.altkomsoftware.lab.ebidder.listings.infrastructure.time.SystemClock;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AnswerQuestionService {

    private final QuestionRepository questions;
    private final EventPublisher eventPublisher;

    public void answer(UUID questionId, String answer, boolean publishOnListing) {
        var question = questions.findBy(questionId);
        //refactor to return question answered
        question.submitAnAnswer(answer, publishOnListing, SystemClock.now());

        eventPublisher.publish(new QuestionAnswered(question.getListingId(), questionId));
    }
}
