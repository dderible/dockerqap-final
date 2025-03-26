package com.example.golfclubqap.tournaments;

import com.example.golfclubqap.members.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Tournament findByTournamentId(Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ERROR: No Tournament with id: " + id + " exists."));
    }

    public List<Tournament> findAllTournaments() {
        return tournamentRepository.findAll();
    }

//    public Tournament updateTournament(Long id, Tournament tournamentDetails) {
//        Tournament tournament = findByTournamentId(id);
//
//        tournament.setStartDate(tournamentDetails.getStartDate());
//        tournament.setEndDate(tournamentDetails.getEndDate());
//        tournament.setLocation(tournamentDetails.getLocation());
//        tournament.setEntryFee(tournamentDetails.getEntryFee());
//        tournament.setPrize(tournamentDetails.getPrize());
//
//        return tournamentRepository.save(tournament);
//    }

    public void deleteTournament(Long id) {
        Tournament tournament = findByTournamentId(id);
        tournamentRepository.delete(tournament);
    }

    public List<Tournament> searchTournamentByStartDate(LocalDate startDate) {
        return tournamentRepository.searchTournamentByStartDate(startDate);
    }

    public List<Tournament> searchTournamentByLocation(String location) {
        return tournamentRepository.searchTournamentByLocation(location);
    }

//    public Set<Member> getTournamentMembers(Long id) {
//        Tournament tournament = findByTournamentId(id);
//        return tournament.getMembers();
//    }
}