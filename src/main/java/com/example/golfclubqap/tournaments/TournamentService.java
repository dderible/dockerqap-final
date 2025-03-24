package com.example.golfclubqap.tournaments;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface TournamentService {
    Tournament createTournament(Tournament tournament);
    Tournament findByTournamentId(Long id);
    List<Tournament> findAllTournaments();
    Tournament updateTournament(Long id, Tournament tournament);
    void deleteTournament(Long id);
    Tournament addToTournament(Long tournamentId, Long memberId);
    Tournament removeFromTournament(Long tournamentId, Long memberId);

    List<Tournament> findTournamentsByMemberId(Long memberId);
    List<Tournament> getTournamentsByStartDate(LocalDate startDate);
    List<Tournament> getTournamentsByEndDate(LocalDate endDate);
    List<Tournament> getTournamentsByLocation(String location);
}