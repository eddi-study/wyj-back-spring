package com.example.springPart.memberTest;

import com.example.springPart.member.controller.form.MemberRequestForm;
import com.example.springPart.member.entity.Member;
import com.example.springPart.member.entity.RoleType;
import com.example.springPart.member.repository.MemberRepository;
import com.example.springPart.member.service.MemberService;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.springPart.member.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;
    @Test
    @DisplayName("사용자가 회원가입 가능")
    void 사용자가_회원가입 () throws JSONException {
        final String email = "test@test.com";
        final String password = "test";
        final RoleType role = NORMAL;
        final Integer businessNumber = 1234567899;

        MemberRequestForm requestForm = new MemberRequestForm(email, password, role, businessNumber);
        Member member = requestForm.toMember();
        memberRepository.save(member);
        assertEquals(email, member.getEmail());
        assertEquals(password, member.getPassword());
    }
}
