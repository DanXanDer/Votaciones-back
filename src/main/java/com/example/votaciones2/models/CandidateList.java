package com.example.votaciones2.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CandidateList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCandidateList;

    @Column(nullable = false, length = 100)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "list", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Candidate> candidates;

    @JsonManagedReference
    @OneToMany(mappedBy = "vote", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Voter> voters;
}
