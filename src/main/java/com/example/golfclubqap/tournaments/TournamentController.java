package com.example.golfclubqap.tournaments;

import com.example.golfclubqap.members.Member;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        Tournament newTournament = tournamentService.createTournament(tournament);
        return new ResponseEntity<>(newTournament, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable Long id, @RequestBody Tournament tournament) {
        Tournament updatedTournament = tournamentService.updateTournament(id, tournament);
        return new ResponseEntity<>(updatedTournament, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search-date")
    public ResponseEntity<List<Tournament>> searchTournamentByStartDate(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {

        List<Tournament> tournaments = tournamentService.searchTournamentByStartDate(startDate);
        return new ResponseEntity<>(tournaments, HttpStatus.OK);
    }

    @GetMapping("/search-location")
    public ResponseEntity<List<Tournament>> searchTournamentByLocation(
            @RequestParam(required = false) String location) {

        List<Tournament> tournaments = tournamentService.searchTournamentByLocation(location);
        return new ResponseEntity<>(tournaments, HttpStatus.OK);
    }

//    @GetMapping("/{id}/members")
//    public ResponseEntity<Set<Member>> getTournamentMembers(@PathVariable Long id) {
//        Set<Member> members = tournamentService.getTournamentMembers(id);
//        return new ResponseEntity<>(members, HttpStatus.OK);
//    }
}