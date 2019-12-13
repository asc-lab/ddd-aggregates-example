package pl.altkomsoftware.lab.ebidder.listings.infrastructure.db;

import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.qanda.Question;
import pl.altkomsoftware.lab.ebidder.listings.domain.qanda.QuestionRepository;

import java.util.UUID;

@Component
public class InMemoryQuestionRepository implements QuestionRepository {
    @Override
    public Question findBy(UUID id) {
        return null;
    }

    @Override
    public void add(Question question) {

    }
}
