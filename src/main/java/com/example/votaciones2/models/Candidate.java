package com.example.votaciones2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCandidate;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String lastname;
    @Column(nullable = false, length = 100)
    private String role;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "list",
            referencedColumnName = "idCandidateList",
            foreignKey = @ForeignKey(name = "FK_CandidateList_Candidate")
    )
    private CandidateList list;
}
