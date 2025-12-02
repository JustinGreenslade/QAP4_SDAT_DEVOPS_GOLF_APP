package com.QAP4.golfclub.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        return member != null ? ResponseEntity.ok(member) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Member>> searchMembers(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {

        if (name != null && !name.isEmpty()) {
            List<Member> found = memberService.findByName(name);
            return found.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(found);
        }
        if (phone != null && !phone.isEmpty()) {
            List<Member> found = memberService.findByPhoneNumber(phone);
            return found.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(found);
        }
        if (startDate != null) {
            List<Member> found = memberService.findByMembershipStartDate(startDate);
            return found.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(found);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return ResponseEntity.status(201).body(memberService.createMember(member));
    }
}