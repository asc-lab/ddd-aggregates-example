package pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks;

import lombok.Getter;

import java.util.UUID;

public abstract class Identity {
    @Getter
    protected UUID id;

    public static UUID newId() {
        return UUID.randomUUID();
    }
}
