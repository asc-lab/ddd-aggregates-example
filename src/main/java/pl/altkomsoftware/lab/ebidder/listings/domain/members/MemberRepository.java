package pl.altkomsoftware.lab.ebidder.listings.domain.members;

import java.util.UUID;

public interface MemberRepository {
    Member getMember(UUID memberId);
}
