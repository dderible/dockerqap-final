package com.example.golfclubqap.tournaments;

import com.example.golfclubqap.members.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String location;

    private BigDecimal entryFee;

    private BigDecimal prize;

    @ManyToMany(mappedBy = "tournaments", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Member> members = new HashSet<>();
}