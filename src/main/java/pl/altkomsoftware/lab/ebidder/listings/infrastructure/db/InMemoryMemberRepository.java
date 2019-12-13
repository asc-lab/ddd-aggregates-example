package pl.altkomsoftware.lab.ebidder.listings.infrastructure.db;

import org.springframework.stereotype.Component;
import pl.altkomsoftware.lab.ebidder.listings.domain.members.Member;
import pl.altkomsoftware.lab.ebidder.listings.domain.members.MemberRepository;

import java.util.UUID;

@Component
public class InMemoryMemberRepository implements MemberRepository {
    @Override
    public Member getMember(UUID memberId) {
        return null;
    }
}
