package com.QAP4.golfclub.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameContainingIgnoreCase(String name);
    List<Member> findByPhoneNumberContaining(String phoneNumber);
    List<Member> findByMembershipStartDate(LocalDate membershipStartDate);
}