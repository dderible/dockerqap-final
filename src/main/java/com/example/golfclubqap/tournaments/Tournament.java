package com.example.golfclubqap.tournaments;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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

//    @ManyToMany(mappedBy = "tournaments", fetch = FetchType.LAZY)
//    private Set<Member> members = new HashSet<>();
}