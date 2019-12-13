package pl.altkomsoftware.lab.ebidder.listings.domain.members;

import lombok.Getter;
import pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks.Entity;

import java.util.UUID;

@Getter
public class Member extends Entity<UUID> {
    private boolean canBid;
}
