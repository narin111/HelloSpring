package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// 인터페이스는 다중상속이 됨
// JpaRepository를 extends하고 있으면 스프링 데이터 JPA가 구현체를 자동으로 만들어줌
// 스프링 빈을 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
