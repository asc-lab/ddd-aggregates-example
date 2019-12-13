package pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks;

public interface EventPublisher {
    void publish(DomainEvent event);
}
