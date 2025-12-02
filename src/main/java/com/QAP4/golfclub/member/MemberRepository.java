package com.QAP4.golfclub.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameContainingIgnoreCase(String name);
    List<Member> findByPhoneNumberContaining(String phoneNumber);
    List<Member> findByMembershipType(String membershipType);

    @Query("SELECT m FROM Member m WHERE EXISTS (SELECT 1 FROM Tournament t WHERE m MEMBER OF t.participatingMembers AND t.startDate = :startDate)")
    List<Member> findByTournamentStartDate(@Param("startDate") LocalDate startDate);
}