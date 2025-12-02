package com.QAP4.golfclub.member;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate membershipStartDate;

    @Column(nullable = false)
    private int membershipDurationMonths;

    @Column(nullable = false)
    private String membershipType;

    public Member() {}

    public Member(String name, String address, String email, String phoneNumber, String membershipType,
                  LocalDate membershipStartDate, int membershipDurationMonths) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipType = membershipType;
        this.membershipStartDate = membershipStartDate;
        this.membershipDurationMonths = membershipDurationMonths;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDate getMembershipStartDate() { return membershipStartDate; }
    public void setMembershipStartDate(LocalDate membershipStartDate) { this.membershipStartDate = membershipStartDate; }

    public int getMembershipDurationMonths() { return membershipDurationMonths; }
    public void setMembershipDurationMonths(int membershipDurationMonths) { this.membershipDurationMonths = membershipDurationMonths; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }}
