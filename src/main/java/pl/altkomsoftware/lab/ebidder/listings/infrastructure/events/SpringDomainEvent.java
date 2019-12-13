package pl.altkomsoftware.lab.ebidder.listings.infrastructure.events;

import org.springframework.context.ApplicationEvent;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.DomainEvent;

public abstract class SpringDomainEvent extends ApplicationEvent implements DomainEvent {
    public SpringDomainEvent(Object source) {
        super(source);
    }
}
