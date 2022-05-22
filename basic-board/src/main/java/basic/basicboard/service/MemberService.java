package basic.basicboard.service;

import basic.basicboard.domain.Member;
import basic.basicboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Boolean login(Member member) {
        if (memberRepository.loginCheck(member) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean join(Member member) {
        if (memberRepository.findById(member.getId()) == null) {
            memberRepository.insert(member);
            return true;
        } else {
            return false;
        }
    }

}
