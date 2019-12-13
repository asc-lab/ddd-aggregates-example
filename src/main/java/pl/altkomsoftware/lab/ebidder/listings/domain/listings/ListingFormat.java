package pl.altkomsoftware.lab.ebidder.listings.domain.listings;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ListingFormat {
    private UUID formatId;
    private FormatType format;

    public ListingFormat(UUID formatId, FormatType format) {
        this.formatId = formatId;
        this.format = format;
    }
}
