package com.example.golfclubqap.members;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface MemberService {
    Member createMember(Member member);
    Member findByID(Long id);
    List<Member> getAllMembers();
    Member updateMember(Long id, Member member);
    void deleteMember(Long id);

    List<Member> getMembersByName(String name);
    List<Member> getMembersByEmail(String email);
    List<Member> getMembersByPhone(String phoneNumber);
    List<Member> getMembersByStartDate(LocalDate startDate);
    List<Member> getMembersByDuration(Integer duration);
}