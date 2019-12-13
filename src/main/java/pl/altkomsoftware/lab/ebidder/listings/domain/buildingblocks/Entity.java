package pl.altkomsoftware.lab.ebidder.listings.domain.buildingblocks;

import lombok.Getter;

@Getter
public abstract class Entity<I> {
    protected I id;
}
