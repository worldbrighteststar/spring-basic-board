package basic.basicboard.controller;

import basic.basicboard.domain.Member;
import basic.basicboard.dto.MemberLoginDto;
import basic.basicboard.dto.MemberSignupDto;
import basic.basicboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("member/login")
    public String loginForm() {
        return "member/loginForm";
    }

    @PostMapping("member/login")
    public String login(MemberLoginDto dto) {
        Member member = new Member();
        member.setId(dto.getId());
        member.setPwd(dto.getPwd());

        Boolean result = memberService.login(member);

        if (result == true) {
            return "redirect:/post/list";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("member/create")
    public String createMemberForm() {
        return "member/createMemberForm";
    }

    @PostMapping("member/create")
    public String createMember(MemberSignupDto dto) {
        Member member = new Member();
        member.setId(dto.getId());
        member.setPwd(dto.getPwd());
        member.setName((dto.getPwd()));

        return "redirect:/";
    }



}

