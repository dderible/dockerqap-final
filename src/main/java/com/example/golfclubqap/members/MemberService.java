package com.example.golfclubqap.members;

import com.example.golfclubqap.tournaments.Tournament;
import com.example.golfclubqap.tournaments.TournamentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final TournamentRepository tournamentRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, TournamentRepository tournamentRepository) {
        this.memberRepository = memberRepository;
        this.tournamentRepository = tournamentRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member findByID(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ERROR: No Member with id: " + id + " exists."));
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

//    public Member updateMember(Long id, Member memberDetails) {
//        Member member = findByID(id);
//
//        member.setName(memberDetails.getName());
//        member.setAddress(memberDetails.getAddress());
//        member.setEmail(memberDetails.getEmail());
//        member.setPhoneNumber(memberDetails.getPhoneNumber());
//        member.setStartDate(memberDetails.getStartDate());
//        member.setDuration(memberDetails.getDuration());
//
//        return memberRepository.save(member);
//    }

    public void deleteMember(Long id) {
        Member member = findByID(id);
        memberRepository.delete(member);
    }

    public List<Member> getMembersByName(String name) {
        return memberRepository.findByNameContaining(name);
    }

    public List<Member> getMembersByEmail(String email) {
        return memberRepository.findByEmailContaining(email);
    }

    public List<Member> getMembersByPhone(String phoneNumber) {
        return memberRepository.findByPhoneNumberContaining(phoneNumber);
    }

    public List<Member> getMembersByStartDate(LocalDate startDate) {
        return memberRepository.findByStartDate(startDate);
    }

    public List<Member> getMembersByDuration(Integer duration) {
        return memberRepository.findByDuration(duration);
    }

    public Member addMemberToTournament(Long memberId, Long tournamentId) {
        Member member = findByID(memberId);
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new EntityNotFoundException("ERROR: No Tournament with id: " + tournamentId + " exists."));

        member.addTournament(tournament);
        return memberRepository.save(member);
    }

    public Member removeMemberFromTournament(Long memberId, Long tournamentId) {
        Member member = findByID(memberId);
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new EntityNotFoundException("ERROR: No Tournament with id: " + tournamentId + " exists."));

        member.removeTournament(tournament);
        return memberRepository.save(member);
    }
}