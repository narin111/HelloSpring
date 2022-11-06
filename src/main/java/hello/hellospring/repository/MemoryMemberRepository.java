package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;// 0 1 2 키 값 생성 - 동시성 문제 고려x
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); // 해시맵에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null을 반환할 경우 optional으로 감싼다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 하나 찾으면 반환해버림
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());// 실무에서는 List 많이씀
    }

    public void clearStore(){
        store.clear();
    }
}
