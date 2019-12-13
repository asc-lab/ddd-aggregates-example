package pl.altkomsoftware.lab.ebidder.listings.domain.sellers;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.Entity;

import java.util.UUID;

@Getter
public class Seller extends Entity<UUID> {
    private boolean canList;
}
