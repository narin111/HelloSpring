package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { // ctrl shift t => new test
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){ // 외부에서 memberRepository 넣어줌 -> dependency infection
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 x
        // 바로 꺼내는 것을 권장하지 않음
        validateDuplicateMember(member);
        // ctrl shift alt t extract method // 리팩토링과 관련된 기능들
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    } // ctrl alt m => extract member

    /**
     * 전체회원조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
