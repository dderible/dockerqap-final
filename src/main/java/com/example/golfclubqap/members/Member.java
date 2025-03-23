package com.example.golfclubqap.members;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
// import java.util.HashSet;

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
}