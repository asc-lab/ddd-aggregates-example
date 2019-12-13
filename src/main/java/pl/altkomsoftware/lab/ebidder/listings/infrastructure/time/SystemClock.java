package pl.altkomsoftware.lab.ebidder.listings.infrastructure.time;

import java.time.LocalDateTime;

public class SystemClock {
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
}
