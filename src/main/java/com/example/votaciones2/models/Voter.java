package com.example.votaciones2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVoter;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private String code;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String lastname;
    @Column(nullable = false, length = 100)
    private String role;
    @Column(nullable = false, length = 100)
    private String dni;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "vote",
            referencedColumnName = "idCandidateList",
            foreignKey = @ForeignKey(name = "FK_CandidateList_Candidate")
    )
    private CandidateList vote;
}
