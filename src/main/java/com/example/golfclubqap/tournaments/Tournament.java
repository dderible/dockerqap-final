package com.example.golfclubqap.tournaments;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
// import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "ERROR: Start Date is a required field.")
    private LocalDate startDate;

    @NotNull (message = "ERROR: End Date is a required field.")
    private LocalDate endDate;

    @NotBlank (message = "ERROR: Location is a required field.")
    private String location;

    @NotNull (message = "ERROR: Entry Fee is a required field.")
    @Positive (message = "ERROR: Entry Fee cannot be a negative number.")
    private BigDecimal entryFee;

    @NotNull (message = "ERROR: Cash Prize is a required field.")
    @Positive (message = "ERROR: Cash Prize cannot be a negative number.")
    private BigDecimal prize;
}