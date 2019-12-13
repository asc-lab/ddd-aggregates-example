package pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.vernon;

public interface DomainEventSubscriber<T> {
    void handleEvent(final T aDomainEvent);

    Class<T> subscribedToEventType();
}
