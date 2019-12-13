package pl.altkomsoftware.lab.ebidder.listings.domain.qanda;

import java.util.UUID;

public interface QuestionRepository {
    Question findBy(UUID id);
    void add(Question question);
}
