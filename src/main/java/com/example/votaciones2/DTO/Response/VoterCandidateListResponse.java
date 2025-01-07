package com.example.votaciones2.DTO.Response;

import com.example.votaciones2.models.Candidate;

import java.util.List;

public record VoterCandidateListResponse(
        Integer idCandidateList,
        String name,
        List<Candidate> candidates
) {
}
