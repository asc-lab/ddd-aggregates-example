package pl.altkomsoftware.lab.ebidder.listings.infrastructure.events;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.DomainEvent;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.EventPublisher;

@Component
@RequiredArgsConstructor
public class SpringEventPublisher implements EventPublisher {
    private final ApplicationEventPublisher publisher;

    public void publish(DomainEvent event) {
        publisher.publishEvent(event);
    }
}
