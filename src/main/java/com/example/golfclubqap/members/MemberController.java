package com.example.golfclubqap.members;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findByID(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findByID(id));
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member newMember = memberService.createMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/by-name")
    public ResponseEntity<List<Member>> getMembersByName(@RequestParam String name) {
        return ResponseEntity.ok(memberService.getMembersByName(name));
    }

    @GetMapping("/search/by-email")
    public ResponseEntity<List<Member>> getMembersByEmail(@RequestParam String email) {
        return ResponseEntity.ok(memberService.getMembersByEmail(email));
    }

    @GetMapping("/search/by-phone")
    public ResponseEntity<List<Member>> getMembersByPhone(@RequestParam String phoneNumber) {
        return ResponseEntity.ok(memberService.getMembersByPhone(phoneNumber));
    }

    @GetMapping("/search/by-start-date")
    public ResponseEntity<List<Member>> getMembersByMembershipStartDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        return ResponseEntity.ok(memberService.getMembersByStartDate(startDate));
    }

    @GetMapping("/search/by-duration")
    public ResponseEntity<List<Member>> getMembersByDuration(@RequestParam Integer duration) {
        return ResponseEntity.ok(memberService.getMembersByDuration(duration));
    }

    @PostMapping("/{memberId}/tournaments/{tournamentId}")
    public ResponseEntity<Member> addMemberToTournament(
            @PathVariable Long memberId,
            @PathVariable Long tournamentId) {

        Member member = memberService.addMemberToTournament(memberId, tournamentId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @DeleteMapping("/{memberId}/tournaments/{tournamentId}")
    public ResponseEntity<Member> removeMemberFromTournament(
            @PathVariable Long memberId,
            @PathVariable Long tournamentId) {

        Member member = memberService.removeMemberFromTournament(memberId, tournamentId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}