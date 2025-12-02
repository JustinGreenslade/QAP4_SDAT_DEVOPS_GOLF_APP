package com.QAP4.golfclub.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        Optional<Member> optional = memberRepository.findById(id);
        return optional.orElse(null);
    }

    public List<Member> findByName(String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Member> findByPhoneNumber(String phone) {
        return memberRepository.findByPhoneNumberContaining(phone);
    }

    public List<Member> findByMembershipStartDate(LocalDate date) {
        return memberRepository.findByMembershipStartDate(date);
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }
}