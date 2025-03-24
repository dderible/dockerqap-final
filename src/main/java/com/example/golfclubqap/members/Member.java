package com.example.golfclubqap.members;

import com.example.golfclubqap.tournaments.Tournament;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "ERROR: Name is a required field.")
    private String name;

    @NotBlank (message = "ERROR: Address is a required field.")
    private String address;

    @NotBlank (message = "ERROR: Email is a required field.")
    @Email (message = "ERROR: Invalid or Taken Email.")
    private String email;

    @NotBlank (message = "ERROR: Phone Number is a required field.")
    private String phoneNumber;

    @NotNull (message = "ERROR: Start Date is a required field.")
    private LocalDate startDate;

    @NotNull (message = "ERROR: Membership Length is a required field.")
    private Integer duration;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "member_tournament",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id")
    )
    private Set<Tournament> tournaments = new HashSet<>();

    public void addTournament(Tournament tournament) {
        this.tournaments.add(tournament);
        tournament.getMembers().add(this);
    }

    public void removeTournament(Tournament tournament) {
        this.tournaments.remove(tournament);
        tournament.getMembers().remove(this);
    }
}