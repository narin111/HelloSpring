package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // Test가 하나 끝날 때마다 레포를 깔끔하게 지워주는 것 넣어야함
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test // Test 붙여야 실행가능!!
    public void save() {
        Member member = new Member();
        member.setName("spring"); // command shift enter
        repository.save(member);

        // optional 일 때는 get으로 꺼낼 수 있음 -> 좋은 방법이 아니지만 test코드느 괜찮음
        Member result = repository.findById(member.getId()).get();
        // Assertions.assertEquals(member, result); // 같은지 확인
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // shift f6 누르면 rename 한번에
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        // Member result = repository.findByName("spring2").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
        // assertThat(result.size()).isEqualTo(3);

    }
}