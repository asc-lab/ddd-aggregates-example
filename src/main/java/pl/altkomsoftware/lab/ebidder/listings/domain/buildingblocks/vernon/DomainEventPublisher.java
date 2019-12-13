package pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.vernon;

import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class DomainEventPublisher {
    @SuppressWarnings("unchecked")
    private static final ThreadLocal<List> subscribers = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> publishing = ThreadLocal.withInitial(() -> Boolean.FALSE);

    public static DomainEventPublisher instance() {
        return new DomainEventPublisher();
    }

    public DomainEventPublisher() {
        super();
    }

    @SuppressWarnings("unchecked")
    public <T> void publish(final T aDomainEvent) {
        if (publishing.get()) {
            return;
        }
        try {
            publishing.set(Boolean.TRUE);
            List<DomainEventSubscriber<T>> registeredSubscribers = subscribers.get();
            if (registeredSubscribers != null) {
                Class<?> eventType = aDomainEvent.getClass();
                for (DomainEventSubscriber<T> subscriber : registeredSubscribers) {
                    Class<?> subscribedTo = subscriber.subscribedToEventType();
                    if (subscribedTo == eventType || subscribedTo == DomainEvent.class) {
                        subscriber.handleEvent(aDomainEvent);
                    }
                }
            }
        } finally {
            publishing.set(Boolean.FALSE);
        }
    }

    public DomainEventPublisher reset() {
        if (!publishing.get()) {
            subscribers.set(null);
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> void subscribe(DomainEventSubscriber<T> aSubscriber) {
        if (publishing.get()) {
            return;
        }
        List<DomainEventSubscriber<T>> registeredSubscribers = subscribers.get();
        if (registeredSubscribers == null) {
            registeredSubscribers = new ArrayList<>();
            subscribers.set(registeredSubscribers);
        }
        registeredSubscribers.add(aSubscriber);
    }
}