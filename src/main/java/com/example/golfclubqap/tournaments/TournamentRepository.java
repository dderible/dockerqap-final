package com.example.golfclubqap.tournaments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByStartDate(LocalDate startDate);
    List<Tournament> findByLocation(String location);
    List<Tournament> searchTournaments(
            @Param("startDate") LocalDate startDate,
            @Param("location") String location);
}