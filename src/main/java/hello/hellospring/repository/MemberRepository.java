package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원이 저장소에 저장
    Optional<Member> findById(Long id); // optional 자바8에 포함된 기능 findbyid가 null일 경우 그대로 반환하기보다
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 저장된 모든 회원리스트 전달


}
