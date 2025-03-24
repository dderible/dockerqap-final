package com.example.golfclubqap.tournaments;

import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public ResponseEntity<List<Tournament>> findAllTournaments() {
        return ResponseEntity.ok(tournamentService.findAllTournaments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> findByTournamentId(@PathVariable Long id) {
        return ResponseEntity.ok(tournamentService.findByTournamentId(id));
    }

    @PostMapping
    public ResponseEntity<Tournament> createTournament(@Valid @RequestBody Tournament tournament) {
        Tournament newTournament = tournamentService.createTournament(tournament);
        return new ResponseEntity<>(newTournament, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable Long id, @Valid @RequestBody Tournament tournament) {
        Tournament updatedTournament = tournamentService.updateTournament(id, tournament);
        return new ResponseEntity<>(updatedTournament, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{tournamentId}/members/{memberId}")
    public ResponseEntity<Tournament> addToTournament(
            @PathVariable Long tournamentId, @PathVariable Long memberId) {
        return ResponseEntity.ok(tournamentService.addToTournament(tournamentId, memberId));
    }

    @DeleteMapping("/{tournamentId}/members/{memberId}")
    public ResponseEntity<Tournament> removeFromTournament(
            @PathVariable Long tournamentId, @PathVariable Long memberId) {
        return ResponseEntity.ok(tournamentService.removeFromTournament(tournamentId, memberId));
    }

    @GetMapping("/search/by-memberid")
    public ResponseEntity<List<Tournament>> findTournamentsByMemberId(@RequestParam Long memberId) {
        return ResponseEntity.ok(tournamentService.findTournamentsByMemberId(memberId));
    }

    @GetMapping("/search/by-start-date")
    public ResponseEntity<List<Tournament>> getTournamentsByStartDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        return ResponseEntity.ok(tournamentService.getTournamentsByStartDate(startDate));
    }

    @GetMapping("/search/by-end-date")
    public ResponseEntity<List<Tournament>> getTournamentsByEndDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(tournamentService.getTournamentsByEndDate(endDate));
    }

    @GetMapping("/search/by-location")
    public ResponseEntity<List<Tournament>> getTournamentsByLocation(@RequestParam String location) {
        return ResponseEntity.ok(tournamentService.getTournamentsByLocation(location));
    }
}